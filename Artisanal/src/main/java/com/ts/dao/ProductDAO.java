package com.ts.dao;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Product;

public class ProductDAO {

	public int addProduct(Product product) {
		return HibernateTemplate.addObject(product);
	}

}
