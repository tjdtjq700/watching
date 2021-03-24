package com.w.watching.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Temp extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(Temp.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		if(request.getSession().getAttribute("mid")==null) {
			logger.info("mid is null");
			response.sendRedirect("/");
			return false;
		}
		return true;
	}
	
	public void postGandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object mid = modelMap.get("mid");
		
		if(mid != null) {
			logger.info("mid:"+mid);
			session.setAttribute("mid", mid);
			response.sendRedirect("/product/*");
		}else {
			response.sendRedirect("/product/product_detail");
		}
		logger.info("mid:"+mid);
	}

}
