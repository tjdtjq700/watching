package com.w.watching.Interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.w.watching.VO.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final String LOGIN="login";
	private static final Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("-------------preHandle-------------");
		
		if(logger.isDebugEnabled()) {
			logger.debug("Request URI \t:"+ request.getRequestURI());
		}
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN)!=null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		return true;
	}
	
	public void postGandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("------------postHandle------------");
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object MemberVO = modelMap.get("MemberVO");
		
		if(MemberVO != null) {
			logger.info("new login success");
			logger.info("MemberVO:"+ MemberVO);
			session.setAttribute(LOGIN, MemberVO);
			
			logger.info("MemberVO != null");
			response.sendRedirect("/");
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('등록된 회원이 아닙니다.'); location.href='/member/loginGET';</script>");
			out.flush();
			
			logger.info("MemberVO == null 가입되지 않은 회원");
		}
	}
}
