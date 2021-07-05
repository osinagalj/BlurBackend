package com.tandil.blur.api.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.service.product.ProductService;


@RequestMapping("/api/v0/")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;

	@PostMapping(path = "/productos")
	public ResponseEntity<Product> registerPersona(@RequestBody Product p){
		Product newP = ps.register(p);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP);
	}	

	@GetMapping(path = "/productos")
	public ResponseEntity<List<Product>> getPersonas( ){
		List<Product> list = ps.getAllPersonas();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/productos/{name}/")
	public ResponseEntity<Product> getPersona(@PathVariable(value = "name") String name){
		Product p = ps.findByName(name);		
		return ResponseEntity.ok(p);
	}	

}