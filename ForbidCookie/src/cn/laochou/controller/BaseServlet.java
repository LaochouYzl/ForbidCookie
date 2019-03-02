package cn.laochou.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 	»ùÀà
 * @author Administrator
 *
 */
public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String methodName = request.getParameter("method");
			Class<? extends BaseServlet> c = this.getClass();
			Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}


}
