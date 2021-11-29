package com.watching.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.watching.common.SearchVO;
import com.watching.dto.ProductDTO;
import com.watching.service.ProductService;

@Controller
@RequestMapping("/admin/*")
public class ProductController {
	
	private String attachPath="resources/ProductImg/";
	
	@Inject
	ProductService productService;
	
	//기능 upload(insert),list,delete,update(modify),uphit, detailView
	
	//리스트 화면 출력
	@RequestMapping("list")
	public String list(Model model, SearchVO vo,
					@RequestParam(value="nowPage", required=false)String nowPage,
					@RequestParam(value="searchType", required=false)String searchType,
					@RequestParam(value="keyword", required=false)String keyword,
					HttpServletRequest request) throws Exception {
			
		//페이징
			int cntPerPage=10;
			
			if(nowPage==null) {
				nowPage="1";
			}
			HashMap<String,String> searchMap = new HashMap<String, String>();
			searchMap.put("searchType", searchType);
			searchMap.put("keyword", keyword);
			int total = productService.cntList(searchMap);
			
			vo = new SearchVO(total, Integer.parseInt(nowPage), cntPerPage);
			vo.setSearchType(searchType);
			vo.setKeyword(keyword);
			
			//세션유지
			HttpSession session = request.getSession();
			String aId = (String)session.getAttribute("aId");
			
			model.addAttribute("search", vo);
			model.addAttribute("paging", vo);
			model.addAttribute("dtos", productService.list(vo));
			model.addAttribute("aId", aId);
			
			return "/admin/list";
		}
	
	//업로드 화면 출력, 리스트에서 업로드 버튼을 누르면 나오는 화면
	@RequestMapping("uploadView")
	public String uploadView(Model model, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		model.addAttribute("aId", session.getAttribute("aId"));
		
		return "/admin/uploadView";
	}
	
	//uploadView에서 작성후 업로드 버튼을 누르면 실제로 db에 올라가는 서비스
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String upload(@ModelAttribute ProductDTO dto, 
			@RequestParam("imgFile")MultipartFile imgFile, @RequestParam("vodFile")MultipartFile vodFile,
			HttpServletRequest request) throws Exception{
		
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootPath);

		String pImg = dataUpload(imgFile, rootPath);
		String pVod = dataUpload(vodFile, rootPath);
		dto.setpImg(pImg);
		dto.setpVod(pVod);
		productService.upload(dto);
		
		return "redirect:/admin/list"; //또는 다른 화면
	}
	//파일 업로드가 중복되어 메소드를 새로 만듦
	public String dataUpload(MultipartFile file, String rootPath) throws Exception{
		
		//경로
		
		String originName = file.getOriginalFilename();
		//System.out.println(originName);
		UUID uuid = UUID.randomUUID();
		//저장 파일 생성
		String pdata = uuid.toString()+"_"+originName;
		File target = new File(rootPath+attachPath+pdata);
		FileCopyUtils.copy(file.getBytes(), target);
		return pdata;
	}
	
	//수정을 위한 detailView
	@RequestMapping("view")
	public String view(Model model, @RequestParam("pCode")int pCode) throws Exception{

		model.addAttribute("view", productService.view(pCode));
		return "/admin/view";
	}
	//modifyView
	@RequestMapping("modifyView")
	public String modifyView(Model model, @RequestParam("pCode")int pCode) throws Exception{
		model.addAttribute("view", productService.view(pCode));
		return "/admin/modifyView";
	}
	
	//modifyView에서 수정버튼 누르면 update되는 서비스
	@RequestMapping("modify")
	public String modify(@ModelAttribute ProductDTO dto,
			@RequestParam("imgFile")MultipartFile imgFile, @RequestParam("vodFile")MultipartFile vodFile,
			HttpServletRequest request) throws Exception {		
		//수정전 이미지 파일명 가져오기
		int pCode=dto.getpCode();
		ProductDTO bfDto = productService.view(pCode);
		System.out.println(bfDto.getpImg());
		System.out.println(bfDto.getpVod());
		
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		
		//이미지 변경
		String pImg="";
		if(!imgFile.getOriginalFilename().isEmpty()) {
			pImg = dataUpload(imgFile, rootPath);
			//이전 이미지 삭제
			String filePath = rootPath+attachPath+bfDto.getpImg();
			File bfFile = new File(filePath);
			System.out.println(filePath);
			dataDelete(bfFile);
		}else {
			//사진변경 안함
			pImg = bfDto.getpImg();
		}
		
		//vod 변경
		String pVod="";
		if(!vodFile.getOriginalFilename().isEmpty()) {
			pVod = dataUpload(vodFile, rootPath);
			//이전 영상 삭제
			String filePath = rootPath+attachPath+bfDto.getpVod();
			System.out.println(filePath);
			File bfFile = new File(filePath);
			dataDelete(bfFile);
		}else {
			//영상 변경 안함
			pVod = bfDto.getpVod();
		}
		System.out.println(pImg);
		System.out.println(pVod);
		dto.setpImg(pImg);
		dto.setpVod(pVod);
		productService.modify(dto);
		
		return "redirect:/admin/view?pCode="+pCode;
	}
	//파일삭제
	public void dataDelete(File file) {
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일삭제완료");
			}else {
				System.out.println("파일 삭제 실패");
			}
		}else {
			System.out.println("파일 존재하지않음");
		}
	}
	
	//삭제는 list에서 삭제버튼 누르면 바로 실행
	@RequestMapping("delete")
	public String delete(HttpServletRequest request) throws Exception{
		String[] pCodes = request.getParameterValues("pCodes");
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		//선택확인
		for(String i : pCodes)System.out.println(Integer.parseInt(i));
		for(String i : pCodes) {
			//파일삭제
			ProductDTO delDto = productService.view(Integer.parseInt(i));
			
			String imgFilePath = rootPath+attachPath+delDto.getpImg();
			String vodFilePath = rootPath+attachPath+delDto.getpVod();
			
			File imgFile = new File(imgFilePath);
			File vodFile = new File(vodFilePath);
			dataDelete(imgFile);
			dataDelete(vodFile);
			productService.delete(Integer.parseInt(i));			
		}
		return "redirect:/admin/list";	
	}
	
	
}