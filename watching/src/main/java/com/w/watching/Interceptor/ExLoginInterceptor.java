package com.w.watching.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExLoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(ExLoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception{
		
		super.postHandle(request, response, handler, modelAndView);	
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
				
		System.out.println("preHandle-----------------");
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("login");
		
		if(obj==null) {
			response.sendRedirect("/");
			System.out.println("mid,mpw NULL");
			return false;
		}
		return false;
	}	
}
