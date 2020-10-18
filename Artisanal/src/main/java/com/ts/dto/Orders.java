package com.ts.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Orders {
	
	@Id
	@GeneratedValue
	public int orderId;
	private String orderStatus;
	private java.util.Date orderDate;
	private java.util.Date shippedDate;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToMany(mappedBy="orders",fetch = FetchType.LAZY)
	List<OrderDetails> orderDetailsList =new ArrayList<OrderDetails>();

	
	
	public Orders() {
		
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public java.util.Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(java.util.Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orders=" + customer + ", orderStatus=" + orderStatus + ", orderDate="
				+ orderDate + ", shippedDate=" + shippedDate + "]";
	}
	
	
	
}