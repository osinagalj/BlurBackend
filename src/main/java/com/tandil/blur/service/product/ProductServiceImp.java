package com.tandil.blur.service.product;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.persistence.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository pr;

	
	@Override
	public Product register(Product p) {
		return pr.save(p);
	}

	@Override
	public Product findByName(String name) {
		return pr.findByName(name);
	}
	
	public List<Product> getAllPersonas(){
		List<Product> personas = new ArrayList<Product>();
		Iterator<Product> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Product product = it.next();
			personas.add(product);
		}
		return personas;
	}

}