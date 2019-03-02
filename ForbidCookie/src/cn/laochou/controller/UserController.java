package cn.laochou.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.laochou.pojo.Product;
import cn.laochou.pojo.User;
import cn.laochou.utils.PackObject;


@WebServlet("/user")
public class UserController extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = PackObject.getObject(request, User.class);
		request.getSession().setAttribute("user", user);
		System.out.println(user);
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		return;
	}
	
	public void buy(HttpServletRequest request, HttpServletResponse response) {
		Product product = PackObject.getObject(request, Product.class);
		System.out.println("当前用户:" + request.getSession().getAttribute("user").toString());
		if(request.getSession().getAttribute("prods") == null) {
			List<Product> list = new ArrayList<Product>();
			request.getSession().setAttribute("prods", list);
		}else {
			@SuppressWarnings("unchecked")
			List<Product> list = (List<Product>) request.getSession().getAttribute("prods");
			list.add(product);
			request.getSession().setAttribute("prods", list);
		}
		
	}

}
