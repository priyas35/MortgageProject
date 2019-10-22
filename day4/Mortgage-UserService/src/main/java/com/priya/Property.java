package com.priya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	   @Id
       private int id;
	
	    @Column private String propertytype;
	 
	   @Column
       private int propertyworth;
	   @Column
       private int loanamount;
	   @Column
       private int propertyweight;
	   @Column
       private int lyear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPropertytype() {
		return propertytype;
	}
	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}
	public int getPropertyworth() {
		return propertyworth;
	}
	public void setPropertyworth(int propertyworth) {
		this.propertyworth = propertyworth;
	}
	public int getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(int loanamount) {
		this.loanamount = loanamount;
	}
	public int getPropertyweight() {
		return propertyweight;
	}
	public void setPropertyweight(int propertyweight) {
		this.propertyweight = propertyweight;
	}
	public int getLyear() {
		return lyear;
	}
	public void setLyear(int lyear) {
		this.lyear = lyear;
	}
	   
	   
	   
	
	
       
       
}
