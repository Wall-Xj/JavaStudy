package com.sn.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sn.entity.Product;

@Repository
public interface ProductMapper {
	List<Product> getList();

	Product findById(int id);
}
