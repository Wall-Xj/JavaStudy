package com.sn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sn.entity.Product;
import com.sn.mapper.ProductMapper;
import com.sn.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Resource
	public ProductMapper productMapper;
	
	public List<Product> getList() {
		return productMapper.getList();
	}

	@Override
	public Product findById(int id) {
		return productMapper.findById(id);
	}

}