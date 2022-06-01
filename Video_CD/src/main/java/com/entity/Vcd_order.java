package com.entity;

public class Vcd_order {
	private int id;
	private String orderId;
	private String userName;
	private String email;
	private String phoneno;
	private String fullAdd;
	
	private String vcdName;
	private String actors;
	private String price;
	private String paymentType;
	public Vcd_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getVcdName() {
		return vcdName;
	}
	public void setVcdName(String vcdName) {
		this.vcdName = vcdName;
	}

	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getFullAdd() {
		return fullAdd;
	}
	public void setFullAdd(String fullAdd) {
		this.fullAdd = fullAdd;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Vcd_order [id=" + id + ", userName=" + userName + ", email=" + email + ", phoneno=" + phoneno
				+ ", fullAdd=" + fullAdd + ", paymentType=" + paymentType + "]";
	}
	

}
