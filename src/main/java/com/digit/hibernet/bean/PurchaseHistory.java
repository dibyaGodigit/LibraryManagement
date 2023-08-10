package com.digit.hibernet.bean;

public class PurchaseHistory {
int pid;
int book_id;
String bname;
int uid;
int amount;
String invoice;
/**
 * @return the invoice
 */
public String getInvoice() {
	return invoice;
}
/**
 * @param invoice the invoice to set
 */
public void setInvoice(String invoice) {
	this.invoice = invoice;
}
/**
 * @return the bname
 */
public String getBname() {
	return bname;
}
/**
 * @param bname the bname to set
 */
public void setBname(String bname) {
	this.bname = bname;
}

/**
 * @return the pid
 */
public int getPid() {
	return pid;
}
/**
 * @param pid the pid to set
 */
public void setPid(int pid) {
	this.pid = pid;
}
/**
 * @return the book_id
 */
public int getBook_id() {
	return book_id;
}
/**
 * @param book_id the book_id to set
 */
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
/**
 * @return the name
 */

/**
 * @return the uid
 */
public int getUid() {
	return uid;
}
/**
 * @param uid the uid to set
 */
public void setUid(int uid) {
	this.uid = uid;
}
/**
 * @return the amount
 */
public int getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(int amount) {
	this.amount = amount;
}


}
