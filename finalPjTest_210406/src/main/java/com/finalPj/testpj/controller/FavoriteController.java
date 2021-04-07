package com.finalPj.testpj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finalPj.testpj.dto.FavoriteDTO;
import com.finalPj.testpj.service.FavoriteService;

@Controller
@RequestMapping("/favorite/*")
public class FavoriteController {
	
	@Inject
	FavoriteService favsvc;
	
	// 찜리스트
	@RequestMapping(value="/favlist")
	public ModelAndView favlist(ModelAndView mav, HttpSession session) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String mId = (String) session.getAttribute("mId");
		
		List<FavoriteDTO> favlist = favsvc.favlist(mId);
		
		map.put("favlist", favlist);
		
		mav.setViewName("favorite/favlist");
		mav.addObject("map", map);
	
		return mav;

	}
	
	// 찜추가
	@RequestMapping("addfav")
	public String addfav(@ModelAttribute FavoriteDTO fdto, Model model, HttpSession session) throws Exception {
		
	    String mId = (String)session.getAttribute("mId");
	    
	    model.addAttribute("mId", mId);
	    
	    fdto.setmId(mId);
	    favsvc.addfav(fdto);

		return "redirect:/favorite/favlist";
	}
		
	// 찜삭제
	@RequestMapping("deletefav")
	public String deletefav(@RequestParam int fCode) throws Exception {
		
		favsvc.deletefav(fCode);
		
		return "redirect:/favorite/favlist";
	}
}