package com.tandil.blur.service.product;

import com.tandil.blur.persistence.model.Product;
import java.util.List;


public interface ProductService {
	Product register(Product p);
	Product findByName(String name);
	List<Product> getAllPersonas();

}