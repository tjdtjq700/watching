package com.w.watching.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.w.watching.DTO.AdminDTO;
import com.w.watching.Service.AdminService;
import com.w.watching.VO.MemberVO;

@Controller
@RequestMapping("/watching/admin/*")
public class Admincontroller {

	@Inject
	AdminService adminservice;
	
	// 로그인
	@RequestMapping("login.do")
	public String adminLogin() {
		return "admin/adminLogin";	 // 로그인 페이지
	}
	
	// 로그인 체크
	@RequestMapping(value="logincheck")
	public ModelAndView logincheck(Model model,HttpSession session,MemberVO vo,ModelAndView mav,HttpServletResponse response) throws Exception {
		String name = adminservice.adminlogin(vo);
		
		// 로그인 성공
		if(name != null) {
			session.setAttribute("adminId", vo.mid);
			session.setMaxInactiveInterval(86400); // 특정 세션만 타임아웃 설정
			
			mav.setViewName("admin/adminHome");
			mav.addObject("msg","success");
		}else {
			mav.setViewName("admin/adminLogin");
			mav.addObject("msg","failure");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자 로그인 정보가 아닙니다.');</script>");
			out.flush();
		}
		return mav;
	}
	
	// 관리자 로그아웃
	@RequestMapping("adminlogout")
	public String logout(HttpSession session,Model model) {
		session.invalidate(); // 로그아웃 처리 후 로그인 페이지로 포워딩
		model.addAttribute("msg","logout");
		return "admin.adminLogin";
	}
	
}
