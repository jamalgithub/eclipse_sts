package com.jamal.jsf.convertor;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConvertorBean {
	private double amount;
	private Date date;
	private UrlData urlData;
	
	public double getAmount() {
		return amount;
	}
 
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UrlData getUrlData() {
		return urlData;
	}

	public void setUrlData(UrlData url) {
		this.urlData = url;
	}	
	
}
