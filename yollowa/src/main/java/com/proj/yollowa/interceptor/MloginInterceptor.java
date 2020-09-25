package com.proj.yollowa.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.proj.yollowa.model.entity.login.ManagerLoginVo;
import com.proj.yollowa.service.login.UserService;

public class MloginInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	
	@Inject
	UserService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String manager_id = request.getParameter("manager_id");
		String manager_password = request.getParameter("manager_password");
			
		ManagerLoginVo managerLoginVo=new ManagerLoginVo(manager_id,manager_password);
		
		HttpSession session = request.getSession();
		session.setAttribute(MLOGIN, loginService.loginManagerService(managerLoginVo));
		
		return false;
		
		
	}
}
