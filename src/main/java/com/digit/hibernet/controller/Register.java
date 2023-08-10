package com.digit.hibernet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernet.bean.User;
import com.digit.hibernet.model.HibernateManager;

@WebServlet("/Register")
public class Register extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  User ud=new User();


      ud.setUid(Integer.parseInt(req.getParameter("id")));

      

      ud.setUname(req.getParameter("name"));

      

      ud.setPin(req.getParameter("pin"));

      

      ud.setAddress(req.getParameter("address"));

      

      ud.setPhone(req.getParameter("phone"));

      

      ud.setEmail(req.getParameter("email"));
      
      ud.setStatus(0);

      

      HibernateManager hm =new HibernateManager();

      

      boolean b =hm.registerUser(ud);

      

      

      if(b==true) {

          resp.sendRedirect("/LibraryManagement/RegisterSuccess.html");

      }

      else {

          resp.sendRedirect("/LibraryManagement/RegisterFail.html");

      }
}
}
