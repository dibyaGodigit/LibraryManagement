package com.digit.hibernet.bean;

public class Subscription {
int subs_id;
int uid;
int amount;
String invoice;
String date;
/**
 * @return the subs_id
 */
public int getSubs_id() {
	return subs_id;
}
/**
 * @param subs_id the subs_id to set
 */
public void setSubs_id(int subs_id) {
	this.subs_id = subs_id;
}
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
 * @return the date
 */
public String getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(String date) {
	this.date = date;
}



}
