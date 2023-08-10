package com.digit.hibernet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernet.model.HibernateManager;

@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	HibernateManager hbm = new HibernateManager();
	hbm.UpdateSpecificBookStatus(id);
}
}
