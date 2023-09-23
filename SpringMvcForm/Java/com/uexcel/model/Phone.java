package com.uexcel.model;

public class Phone {
	private String areacode;
	private String prefix;
	private String number;

	public String getAreacode() {
		return areacode;
	}
  
	
	public Phone() {
	
	}


	public Phone(String areacode, String prefix, String number) {
		super();
		this.areacode = areacode;
		this.prefix = prefix;
		this.number = number;
	}


	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [areacode=" + areacode + ", prefix=" + prefix + ", number=" + number + "]";
	}

}
