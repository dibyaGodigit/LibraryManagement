package com.digit.hibernet.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernet.bean.PurchaseHistory;
import com.digit.hibernet.model.HibernateManager;

@WebServlet("/purchase")
public class Purchase extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bid = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		String name = (String)session.getAttribute("bname");
		int amount = (int)session.getAttribute("cost");
		int uid = (int)session.getAttribute("uid");
		
		Random rand = new Random();
		int invoice = 100000+rand.nextInt();
		
		PurchaseHistory p = new PurchaseHistory();
		p.setBname(name);
		p.setAmount(amount);
		p.setUid(uid);
		p.setBook_id(bid);
		p.setInvoice(invoice+"");
		
		HibernateManager hbm = new HibernateManager();
		if(hbm.purchaseInsert(p)) {
			  resp.sendRedirect("/LibraryManagement/PurchaseSucessFull.html");
		}
		else {
			  resp.sendRedirect("/LibraryManagement/PurchasingFail.html");
		}
		
	}

}
