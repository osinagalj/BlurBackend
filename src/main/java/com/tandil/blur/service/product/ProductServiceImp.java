package com.tandil.blur.service.product;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.persistence.repository.ImageRepository;
import com.tandil.blur.persistence.repository.ProductRepository;
import com.tandil.blur.service.image.ImageService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository pr;
	
	@Autowired
	ImageService ir;

	
	public void remove(Long id) {
		Product p = pr.findProductById(id);
		ir.deleteAllImagesOfProduct(p.getId());
		 pr.deleteById(id);
	}
	
	@Override
	public Product register(Product p) {
		return pr.save(p);
	}

	@Override
	public Product findByName(String name) {
		return pr.findByName(name);
	}
	
	@Override
	public Product findProductById(Long id) {
		return pr.findProductById(id);
	}
	
	@Override
	public Boolean saveImage(byte[] img) {
		Iterator<Product> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Product product = it.next();
			this.register(product);
			//pr.findProductById(id);
		}
		
		return true;
	}
	
	 
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		Iterator<Product> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Product product = it.next();
			products.add(product);
		}
		return products;
	}

}