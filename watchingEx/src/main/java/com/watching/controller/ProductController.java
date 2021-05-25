package com.watching.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watching.dto.ProductDTO;
import com.watching.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService pService;
	
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request,
					ProductDTO dto) throws Exception{
		
		model.addAttribute("dtos", pService.list());
		
		return "/admin/list";
	}
	//상세화면
	@RequestMapping("/view")
	public String view(Model model, @RequestParam("pId")int pId) throws Exception{
		
		model.addAttribute("dto", pService.view(pId));
		
		return "/admin/view";
	}
	
	@RequestMapping("/uploadView")
	public String uploadView(Model model, HttpServletRequest request) throws Exception{
		
		return "/admin/uploadView";
	}
	
	@PostMapping("/upload")
	public String upload(@ModelAttribute ProductDTO dto) throws Exception {
		logger.info("pName : "+dto.getpName());
		pService.upload(dto);
		
		return "redirect:/admin/list";
	}
	
	@GetMapping("/modifyView")
	public String modifiView(Model model, @RequestParam("pId")int pId) throws Exception{
		model.addAttribute("dto", pService.view(pId));
		
		return "/admin/modifyView";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute ProductDTO dto) throws Exception{
		pService.modify(dto);
		return "redirect:/admin/view?pId="+dto.getpId();
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception{
		String[] pIds = request.getParameterValues("pIdChk");
		for(String i : pIds) {
			pService.delete(i);
		}
		return "redirect:/admin/list";
	}
	
	

}
