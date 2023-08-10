package com.digit.hibernet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernet.bean.Admin;
import com.digit.hibernet.model.HibernateManager;

@WebServlet("/AdminLogin")
public class adminLogin extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String pass = req.getParameter("pin");
	

	HibernateManager hbm = new HibernateManager();
	if(hbm.checkAdmin(id,pass)) {
		resp.sendRedirect("/LibraryManagement/AdminService.html");
	}
	else {
		resp.sendRedirect("/CourseManagementMVC/LoginFail.html");
	}
}
}
