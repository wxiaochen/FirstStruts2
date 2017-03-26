package cn.itcast.framework.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

public class RegisterAction {

	public Object register(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		Object uri = null;
		
		//1.获取请求数据，封装
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
				
		//2.调用service
		UserService userService = new UserService();
		userService.register(user);
		
		//3.跳转
		//request.getRequestDispatcher("/login.jsp").forward(request, response);
		//uri = request.getRequestDispatcher("/login.jsp");
		return "registerSuccess";	//返回注册的标记：registerSuccess = /login.jsp
		
	}
	
}
