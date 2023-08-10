package com.digit.hibernet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernet.bean.Subscription;
import com.digit.hibernet.model.HibernateManager;

@WebServlet("/subs")
public class subscription extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	int subsid = Integer.parseInt(req.getParameter("id"));
	int amount;
	if(subsid == 1) {
		amount =2000;
	}
	else if(subsid == 2) {
		amount=1500;
	}
	else if(subsid == 3) {
		amount = 1000;
	}else {
		amount=500;
	}
	int uid = (int)session.getAttribute("uid");
	Random rand = new Random();
	String invoice = 100000+rand.nextInt(100000)+"";
	
	 Date date = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
      String dat = formatter.format(date);
      
      Subscription s = new Subscription();
      s.setSubs_id(subsid);
      s.setDate(dat);
      s.setAmount(amount);
      s.setInvoice(invoice);
      s.setUid(uid);
      
      HibernateManager hbm = new HibernateManager();
      
      if(hbm.addSubscription(s)) {
    	  resp.sendRedirect("/LibraryManagement/Subscribed.html");
      }
      else {
    	  resp.sendRedirect("/LibraryManagement/NotSubscribed.html");
      }
      
      
	
}
}
