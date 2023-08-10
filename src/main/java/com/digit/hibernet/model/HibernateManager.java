package com.digit.hibernet.model;



import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernet.bean.Book;
import com.digit.hibernet.bean.PurchaseHistory;
import com.digit.hibernet.bean.Subscription;
import com.digit.hibernet.bean.User;



public class HibernateManager {
	private Session session;
	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

		 

        ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());

 

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

 

        session = sessionFactory.openSession();

 

        System.out.println("Connected to Pf...");
		
	}
	
	public Session createSession() {
		return session;
	}
	
	
	
	
	// instering 
	  public boolean registerUser(User e) {

		  

	        Transaction trn = session.beginTransaction();

	 

	        session.save(e);

	 

	        trn.commit();

	 

	        System.out.println("Object Saved!");

	 return true;

	    }
	  
	  public boolean purchaseInsert(PurchaseHistory e) {

		  

	        Transaction trn = session.beginTransaction();

	 

	        session.save(e);

	 

	        trn.commit();

	 

	        System.out.println("Object Saved!");

	 return true;

	    }
	  
	  
	  public boolean addBook(Book e) {

		  

	        Transaction trn = session.beginTransaction();

	 

	        session.save(e);

	 

	        trn.commit();

	 

	        System.out.println("Object Saved!");

	 return true;

	    }
	  
	  public boolean addSubscription(Subscription e) {

		  

	        Transaction trn = session.beginTransaction();

	 

	        session.save(e);

	 

	        trn.commit();

	 

	        System.out.println("Object Saved!");

	 return true;

	    }
	  
	  
	  public boolean checkAdmin(int id,String pass) {
		  
		  Transaction t = session.beginTransaction();
		  Query q = session.createQuery("from Admin where admin_id=:id and pin=:pin");
		 q.setParameter("id", id);
		 q.setParameter("pin", pass);
		 
		  Iterator<?> itr = q.iterate();
		  if(itr.hasNext()) {
			  return true;
		  }
		  else {
			  t.commit();
			  return false;
		  }
		  
		  
	  }

  public boolean checkUser(String id,String pass) {
		  
		  Transaction t = session.beginTransaction();
		  Query q = session.createQuery("from User where uname=:id and pin=:pin and status=:st");
		 q.setParameter("id", id);
		 q.setParameter("pin", pass);
		 q.setParameter("st", 1);
		 
		  Iterator<?> itr = q.iterate();
		  if(itr.hasNext()) {
			  return true;
		  }
		  else {
			  t.commit();
			  return false;
		  }
		  
		  
	  }

	  
	  
	
	  //select * from Employee where id=id
	  // this is only applicable for working with the primary key (id) present in the table .
//	  public Adhar selectSpecific(String id) {
//		  Transaction t = session.beginTransaction();
//		  Adhar s = (Adhar)session.get(Adhar.class, id);
//		 if(s!=null) {
//			 return s;
//		 }
//		 return null;
//	  }
//	  
////	  // select * from employee where name=name;
////	  public void selectSpecific() {
////		  
////		  Transaction t = session.beginTransaction();
////		  Query q = session.createQuery("from Employee where name=:name");
////		  q.setParameter("name", "Dibya");
////		  List list = q.list();
////		  Iterator itr = q.iterate();
////		  while(itr.hasNext()) {
////			  Employee s = (Employee) itr.next();
////			  System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
////		  }
////		  t.commit();
////		  
////	  }
////	  
////	  //select * from employee where name=:name or company=:company order by name
////	  public void selectSpecificWithCondition()
////	  {
////		  Transaction t = session.beginTransaction();
////		  Query q = session.createQuery("from Employee where name=:name or company=:company order by name");
////		  q.setParameter("name", "Dibya");
////		  q.setParameter("company", "Digit");
////		  List list = q.list();
////		  Iterator itr = q.iterate();
////		  while(itr.hasNext()) {
////			  Employee s = (Employee) itr.next();
////			  System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
////		  }
////		  t.commit();
////	  }
////	  
//	  // Alter table employee Update name = name where id=id
//	  // based on primary key
	  public boolean UpdateSpecificBook(int id) {
		  Transaction t = session.beginTransaction();
		  Book s = (Book)session.get(Book.class, id);
		  s.setStatus(1);
		  session.update(s);
		  t.commit();
		  return true;
		 
	  }
	  
	  public boolean UpdateSpecificUser(int id) {
		  Transaction t = session.beginTransaction();
		  User s = (User)session.get(User.class, id);
		  s.setStatus(1);
		  session.update(s);
		  t.commit();
		  return true;
		 
	  }
	  
	  public boolean UpdateSpecificBookStatus(int id) {
		  Transaction t = session.beginTransaction();
		  Book s = (Book)session.get(Book.class, id);
		  s.setStatus(0);
		  System.out.println(s.getStatus());
		  session.update(s);
		  t.commit();
		  return true;
		 
	  }
	  
	  public boolean UpdateSpecificUserStatus(int id) {
		  Transaction t = session.beginTransaction();
		  User s = (User)session.get(User.class, id);
		  s.setStatus(0);
		  session.update(s);
		  t.commit();
		  return true;
		 
	  }
//	  
//	  // 
//	  public boolean DeleteSpecificBook(int id) {
//		  Transaction t = session.beginTransaction();
//		  Book s = (Book)session.get(Book.class, id);
//		  try {
//		  session.delete(s);
//		  }catch(Exception e) {
//			  return false;
//		  }
//		  t.commit();
//		  return true;
//		 // System.out.println(s.getID()+" "+s.getName()+" "+s.getAge()+" "+s.getCompany());
//	  }
//}
//
}
