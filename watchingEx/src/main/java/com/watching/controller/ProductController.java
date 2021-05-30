package com.watching.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.watching.dto.ProductDTO;
import com.watching.service.ProductService;
import com.watching.vo.ProductImgVO;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService pService;
	
	private String imgAttachPath="resources/ProductImg/";
	private String vodAttachPath="resources/ProductVod/";
	
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request,
					ProductDTO dto) throws Exception{
		
		model.addAttribute("dtos", pService.list());
		
		return "/admin/list";
	}
	//��ȭ��
	@RequestMapping("/view")
	public String view(Model model, @RequestParam("pId")int pId) throws Exception{
		
		model.addAttribute("dto", pService.view(pId));
		model.addAttribute("vo", pService.viewImg(pId));
		
		return "/admin/view";
	}
	
	@RequestMapping("/uploadView")
	public String uploadView(Model model, HttpServletRequest request) throws Exception{
		
		return "/admin/uploadView";
	}
	
	@PostMapping("/upload")
	public String upload(@ModelAttribute ProductDTO dto, HttpServletRequest request,
						@RequestParam("imgFile")MultipartFile imgFile, @RequestParam("vodFile")MultipartFile vodFile) throws Exception {
		logger.info("pName : "+dto.getpName());
		
		pService.upload(dto);
		//pId�� �������� �ڵ带 �ۼ��ؾ���
		int pId = pService.getPId(dto.getpName());
		//�̹��� �� ���� ����
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String pImg = imgFile(imgFile, rootPath);
		String pVod = vodFile(vodFile, rootPath);
		
		ProductImgVO vo = new ProductImgVO();
		vo.setpId(pId);
		vo.setpImg(pImg);
		vo.setpVod(pVod);
		
		pService.imgUpload(vo);
		pService.vodUpload(vo);		
		
		return "redirect:/admin/list";
	}
	//�̹��� ����ó��
	public String imgFile(MultipartFile imgFile, String rootPath) throws Exception {
		String originName = imgFile.getOriginalFilename();
		//������ ����
		UUID uuid = UUID.randomUUID();
		String pImgData = uuid.toString()+"_"+originName;
		File target = new File(rootPath+imgAttachPath+pImgData);
		FileCopyUtils.copy(imgFile.getBytes(), target);
		
		return pImgData;
	}
	//������ ����ó��
	public String vodFile(MultipartFile vodFile, String rootPath) throws Exception {
		String originName = vodFile.getOriginalFilename();
		//������ ����
		UUID uuid = UUID.randomUUID();
		String pVodData = uuid.toString()+"_"+originName;
		File target = new File(rootPath+vodAttachPath+pVodData);
		FileCopyUtils.copy(vodFile.getBytes(), target);
		
		return pVodData;
	}
	
	@GetMapping("/modifyView")
	public String modifiView(Model model, @RequestParam("pId")int pId) throws Exception{
		model.addAttribute("dto", pService.view(pId));
		model.addAttribute("vo", pService.viewImg(pId));
		
		return "/admin/modifyView";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute ProductDTO dto, HttpServletRequest request,
			@RequestParam("imgFile")MultipartFile imgFile, @RequestParam("vodFile")MultipartFile vodFile) throws Exception{
		//������ pId ��������
		int pId = dto.getpId();
		
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		
		//�̹�������
		String pImg="";
		ProductImgVO bfVO = pService.viewImg(dto.getpId());
		if(!imgFile.getOriginalFilename().isEmpty()) {
			String filePath = rootPath+imgAttachPath+bfVO.getpImg();
			File bfFile = new File(filePath);
			dataDelete(bfFile);
			pImg = imgFile(imgFile, rootPath);
		}else {
			pImg = bfVO.getpImg();
		}
		//vod����
		String pVod="";
		if(!vodFile.getOriginalFilename().isEmpty()) {
			String filePath = rootPath+vodAttachPath+bfVO.getpVod();
			File bfFile = new File(filePath);
			dataDelete(bfFile);
			pVod = vodFile(vodFile, rootPath);
		}else {
			pVod = bfVO.getpVod();
		}
		
		pService.modify(dto);
		
		ProductImgVO vo = pService.viewImg(pId);		
		vo.setpImg(pImg);
		vo.setpVod(pVod);
		pService.modifyImg(vo);
		
		return "redirect:/admin/view?pId="+dto.getpId();
	}
	
	//�̹��� ���� ����
	public void dataDelete(File file) {
		if(file.exists()) {
			if(file.delete()) {
				logger.info("���ϻ����Ϸ�");
			}else {
				logger.info("���� ���� ����");
			}
		}else {
			logger.info("���� ������������");
		}
	}	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception{
		String[] pIds = request.getParameterValues("pIdChk");
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		for(String i : pIds) {
			
			ProductImgVO vo = pService.viewImg(Integer.parseInt(i));
			if(vo!=null) {				
				String imgFilePath = rootPath+imgAttachPath+vo.getpImg();
				String vodFilePath = rootPath+vodAttachPath+vo.getpVod();
				File imgFile = new File(imgFilePath);
				File vodFile = new File(vodFilePath);
				dataDelete(imgFile);
				dataDelete(vodFile);
				
				pService.deleteImg(i);
			}
			pService.delete(i);
		}
		return "redirect:/admin/list";
	}
	
	

}
