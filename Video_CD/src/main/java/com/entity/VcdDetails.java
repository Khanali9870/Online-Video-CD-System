package com.entity;

public class VcdDetails {
	private int vcdId;
	private String vcdName;
	private String actors;
	private String price;
	private String vcdCategory;
	private String status;
	private String photoName;
	private String email;
	public VcdDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VcdDetails(String vcdName, String actors, String price, String vcdCategory, String status, String photoName,
			String email) {
		super();
		this.vcdName = vcdName;
		this.actors = actors;
		this.price = price;
		this.vcdCategory = vcdCategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
	}
	public int getVcdId() {
		return vcdId;
	}
	public void setVcdId(int vcdId) {
		this.vcdId = vcdId;
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
	public String getVcdCategory() {
		return vcdCategory;
	}
	public void setVcdCategory(String vcdCategory) {
		this.vcdCategory = vcdCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "VcdDetails [vcdId=" + vcdId + ", vcdName=" + vcdName + ", actors=" + actors + ", price=" + price
				+ ", vcdCategory=" + vcdCategory + ", status=" + status + ", photoName=" + photoName + ", email="
				+ email + "]";
	}
	
	
	
}
