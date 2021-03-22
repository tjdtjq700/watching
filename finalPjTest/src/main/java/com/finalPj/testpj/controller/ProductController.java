package com.finalPj.testpj.controller;

import java.io.File;
<<<<<<< HEAD
import java.util.UUID;
=======
<<<<<<< HEAD
import java.util.UUID;
=======
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
>>>>>>> ebb2f93d062771b420bfdc42de4a88fa24be8695

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalPj.testpj.HomeController;
import com.finalPj.testpj.dto.ProductDTO;
import com.finalPj.testpj.service.ProductService;


@Controller
@RequestMapping("/admin/*")
public class ProductController {
	
	
	@Inject
	ProductService productService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//기능 upload(insert),list,delete,update(modify),uphit, detailView
	
	//리스트 화면 출력
	@RequestMapping("list")
	public String list(Model model) throws Exception{

		model.addAttribute("dtos", productService.list());
		
		return "/admin/list2";
	}
	
	//업로드 화면 출력, 리스트에서 업로드 버튼을 누르면 나오는 화면
	@RequestMapping("uploadView")
	public String uploadView(Model model) throws Exception{
		return "/admin/uploadView";
	}
	
	//uploadView에서 작성후 업로드 버튼을 누르면 실제로 db에 올라가는 서비스
	@RequestMapping(value="upload", method=RequestMethod.POST)
<<<<<<< HEAD
	public String upload(@ModelAttribute ProductDTO dto, MultipartFile imgFile, MultipartFile vodFile) throws Exception{

		String pImg = dataUpload(imgFile);
		String pVod = dataUpload(vodFile);
		dto.setpImg(pImg);
		dto.setpVod(pVod);
=======
	public String upload(@ModelAttribute ProductDTO dto, MultipartFile file) throws Exception{
	
		
<<<<<<< HEAD
		String originName = file.getOriginalFilename();
		//파일명 중복방지를 위한 랜덤생성
		UUID uuid = UUID.randomUUID();		
		String pImg = uuid.toString()+"_"+originName;
=======
		String pImg = file.getOriginalFilename();
		
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
		//임시 디렉토리에 사진을 저장
		File target = new File(uploadPath, pImg);
		//위의 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(file.getBytes(), target);
		//파일이름 지정
		dto.setpImg(pImg);
		
>>>>>>> ebb2f93d062771b420bfdc42de4a88fa24be8695
		productService.upload(dto);
		
		return "redirect:/admin/list"; //또는 다른 화면
	}
	//파일 업로드가 중복되어 메소드를 새로 만듦
	public String dataUpload(MultipartFile file) throws Exception{
		String originName = file.getOriginalFilename();
		System.out.println(originName);
		UUID uuid = UUID.randomUUID();		
		String pdata = uuid.toString()+"_"+originName;
		File target = new File(uploadPath, pdata);
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
<<<<<<< HEAD
	public String modify(@ModelAttribute ProductDTO dto, MultipartFile imgFile, MultipartFile vodFile) throws Exception {		
=======
	public String modify(@ModelAttribute ProductDTO dto, MultipartFile file) throws Exception {		
<<<<<<< HEAD
>>>>>>> ebb2f93d062771b420bfdc42de4a88fa24be8695
		//수정전 이미지 파일명 가져오기
		int pCode=dto.getpCode();
		ProductDTO bfDto = productService.view(pCode);
		System.out.println(bfDto.getpImg());
<<<<<<< HEAD
		System.out.println(bfDto.getpVod());
		
		//이미지 변경
		String pImg="";
		if(!imgFile.getOriginalFilename().isEmpty()) {
			pImg = dataUpload(imgFile);
			//이전 이미지 삭제
			String filePath = uploadPath+bfDto.getpImg();
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
			pVod = dataUpload(vodFile);
			//이전 영상 삭제
			String filePath = uploadPath+bfDto.getpVod();
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
=======
		
		//사진 변경
		String pImg="";
		if(!file.getOriginalFilename().isEmpty()) {
			String originName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();		
			pImg = uuid.toString()+"_"+originName;			
			File target = new File(uploadPath, pImg);
			FileCopyUtils.copy(file.getBytes(), target);
			//이전 이미지 삭제
			String filePath = uploadPath+bfDto.getpImg();
			File bfFile = new File(filePath);
			if(bfFile.exists()) {	
				if(bfFile.delete()) {
					System.out.println("이미지 파일 삭제 완료");
				}else {
					System.out.println("이미지 파일 삭제 실패");
				}
			}else {
				System.out.println("파일이 존재하지 않음");
			}
		}else {
			//사진변경 안함
			pImg = bfDto.getpImg();
		}		
		System.out.println(pImg);
		dto.setpImg(pImg);
		productService.modify(dto);
		
		return "redirect:/admin/view?pCode="+pCode;
=======
		String pImg = file.getOriginalFilename();
		
		//임시 디렉토리에 사진을 저장
		File target = new File(uploadPath, pImg);
		//위의 파일을 지정된 디렉토리로 복사
		FileCopyUtils.copy(file.getBytes(), target);
		//파일이름 지정
		dto.setpImg(pImg);
		
		productService.modify(dto);
		
		return "redirect:/admin/view/{pCode}";
>>>>>>> d5a29378ce99780a825098239b6633788a12b478
>>>>>>> ebb2f93d062771b420bfdc42de4a88fa24be8695
	}
	
	//삭제는 list에서 삭제버튼 누르면 바로 실행
	@RequestMapping("delete")
	public String delete(HttpServletRequest request) throws Exception{
		String[] pCodes = request.getParameterValues("pCodes");
		//선택확인
		for(String i : pCodes)System.out.println(Integer.parseInt(i));
		for(String i : pCodes) {
			//파일삭제
			ProductDTO delDto = productService.view(Integer.parseInt(i));
<<<<<<< HEAD
			
			String imgFilePath = uploadPath+delDto.getpImg();
			String vodFilePath = uploadPath+delDto.getpVod();
			
			File imgFile = new File(imgFilePath);
			File vodFile = new File(vodFilePath);
			dataDelete(imgFile);
			dataDelete(vodFile);
=======
			String filePath = uploadPath+delDto.getpImg();
			System.out.println(filePath);
			
			File file = new File(filePath);			
			if(file.exists()) {	
				if(file.delete()) {
					System.out.println("이미지 파일 삭제 완료");
				}else {
					System.out.println("이미지 파일 삭제 실패");
				}
			}else {
				System.out.println("파일이 존재하지 않음");
			}
>>>>>>> ebb2f93d062771b420bfdc42de4a88fa24be8695
			productService.delete(Integer.parseInt(i));			
		}
		return "redirect:/admin/list";	
	}
	
	
}
		
