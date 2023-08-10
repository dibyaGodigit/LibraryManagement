package com.digit.hibernet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernet.model.HibernateManager;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name  = req.getParameter("name");
		String pass = req.getParameter("pin");
		int id = Integer.parseInt(req.getParameter("id"));
		

		HibernateManager hbm = new HibernateManager();
		if(hbm.checkUser(name,pass)) {
			session.setAttribute("uid", id);
			resp.sendRedirect("/LibraryManagement/UserService.html");
		}
		else {
			resp.sendRedirect("/LibraryManagement/LoginFail.html");
		}
	}

}
