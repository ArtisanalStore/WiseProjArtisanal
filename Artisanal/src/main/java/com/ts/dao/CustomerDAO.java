package com.ts.dao;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Customer;

public class CustomerDAO {
	private SessionFactory factory = null;
	
	public int register(Customer customer) {		
		return HibernateTemplate.addObject(customer);
	}

	public Customer getCustomerByUserPass(String loginId, String password) {
		
		return (Customer)HibernateTemplate.getObjectByUserPass(loginId,password);
	}
}
