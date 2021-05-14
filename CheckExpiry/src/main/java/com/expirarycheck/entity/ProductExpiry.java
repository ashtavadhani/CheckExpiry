package com.expirarycheck.entity;

public class ProductExpiry {
private String productName;
private boolean expired;
private float expiretime;

public float getExpiretime() {
	return expiretime;
}
public void setExpiretime(float expiretime) {
	this.expiretime = expiretime;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public boolean isExpired() {
	return expired;
}
public void setExpired(boolean expired) {
	this.expired = expired;
}
public ProductExpiry() {
	super();
	// TODO Auto-generated constructor stub
}


}
