package com.ts.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class  OrderDetails {
	
	@Id
	@GeneratedValue
	private int orderDetailId;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name = "proId")
	private Product product;
	
	private float unitPrice;
	private float totalPrice;
	
	public  OrderDetails() {
		
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}