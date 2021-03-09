package com.w.watching.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginTestController {

	@RequestMapping(value = "/loginfrom.it",method = {RequestMethod.GET, RequestMethod.POST})
	public String loginfrom() {
		System.out.println("loginform 메소드 호출입니다.");
		return "loginform";
	}
	
	// 로그인실패 페이지 요청
	@RequestMapping(value="/loginfail.it",method = RequestMethod.GET)
	public String loginfail() {
		
		// view 정보를 반환하는 부분
		return "loginfail";
	}
	
	// 로그아웃폼 페이지 요청
	@RequestMapping(value="/logoutform.it",method = RequestMethod.GET)
	public String logoutform() {
		// view 정보를 반환하는 부분
		return "/logoutform";		
	}
	
	// 계정별 로그인
	@RequestMapping(value="/loginsuccess.it", method = RequestMethod.GET)
	public String loginresult() {
		return "loginsuccess";
		
	}
	
}
