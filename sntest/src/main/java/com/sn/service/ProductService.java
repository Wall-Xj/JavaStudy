package com.sn.service;

import java.util.List;

import com.sn.entity.Product;

public interface ProductService {
	List<Product> getList();

	Product findById(int id);
}
