package com.digit.hibernet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernet.bean.Book;
import com.digit.hibernet.model.HibernateManager;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  Book bd = new Book();

	  

      bd.setBid(Integer.parseInt(req.getParameter("bid")));



      bd.setBname(req.getParameter("bname"));



      bd.setAuthor(req.getParameter("author"));



      bd.setCost(Integer.parseInt(req.getParameter("cost")));



      bd.setCategory(req.getParameter("category"));



      HibernateManager hm = new HibernateManager();



      boolean b = hm.addBook(bd);



      if (b == true) {



          resp.sendRedirect("/LibraryManagement/AddBookSuccessFull.html");

      } else {

          resp.sendRedirect("/LibraryManagementSystem/AddBookFailed.html");

      }



  }



}
