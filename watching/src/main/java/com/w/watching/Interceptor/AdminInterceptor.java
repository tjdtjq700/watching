package com.w.watching.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{

		private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
		
		@Override
		public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
			
			logger.info("-------------------AdminInterceptor preHandle-------------");
			
			HttpSession session = request.getSession();
			if(session.getAttribute("aid")==null) {
				response.sendRedirect(request.getContextPath()+"/member/loginGET?msg=nologin");
				return false;
			}else {
				return true;	
			}
		}
		
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception{
			super.postHandle(request, response, handler, modelAndView);
		}
}
