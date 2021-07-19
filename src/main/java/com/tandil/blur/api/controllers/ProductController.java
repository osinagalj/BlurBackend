package com.tandil.blur.api.controllers;


import java.io.BufferedReader;  
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tandil.blur.api.inputs.ImageInput;
import com.tandil.blur.api.inputs.ProductInput;
import com.tandil.blur.api.outputs.ProductOutput;
import com.tandil.blur.persistence.mappers.ImageMapper;
import com.tandil.blur.persistence.mappers.ProductMapper;
import com.tandil.blur.persistence.model.Image;
import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.service.image.ImageService;
import com.tandil.blur.service.product.ProductService;
import com.tandil.blur.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v0/")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@Autowired
	ImageService is;

	@PostMapping(path = "/products")
	public ResponseEntity<Product> createProduct(@RequestBody ProductInput p) throws IOException{
		//System.out.print("Producto recibido = " + p);
		System.out.print("Producto recibido 1 = ");
		
		Image image = new Image(p.getImage().getName(),
				p.getImage().getExtension(),
				Utils.compressBytes(p.getImage().getBytes().getBytes()), //Compress image
				p.getImage().getSize()
				);
		Product newP = ProductMapper.map(p);
		newP.setCategoria("");
		Product newP2 = ps.register(newP);
		
		image.setProduct(newP2);
		Image saved = is.register(image);
		

	
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP2.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP2);
	}	

	@GetMapping(path = "/products")
	public ResponseEntity<List<ProductOutput>> getProducts( ){
		List<Product> list = ps.getAllProducts();
		List<ProductOutput> l = new ArrayList();;
		for(Product p : list) {
			ProductOutput pout = ProductMapper.map(p);
			
			pout.setImage(ImageMapper.map(is.findByProduct(p.getId())));
		//tring string = new String(pout.getImage().getBytes());
		//tring string2= new String(pout.getImage().getBytes(),StandardCharsets.UTF_8);
			l.add(pout);
		}
		
		return ResponseEntity.ok(l);
	}

	@DeleteMapping(path = "/products/{id}")
	public ResponseEntity<Product> daleteProduct(@PathVariable(value = "id") Long id ){
		System.out.println("ELiminando el producto " + id);
		ps.remove(id);
		Product p = new Product(); //TODO acomodar para que el front escuche sin que haya una entidad de respuesta
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "/products/{id}")
	public ResponseEntity<ProductOutput> getPersona(@PathVariable(value = "id") Long id){
		System.out.println("obteniendo el producto " + id);
		Product p = ps.findProductById(id);		
		ProductOutput pout = ProductMapper.map(p);
		pout.setImage(ImageMapper.map(is.findByProduct(p.getId())));
		//tring string = new String(pout.getImage().getBytes());
		//tring string2= new String(pout.getImage().getBytes(),StandardCharsets.UTF_8);
			
		return ResponseEntity.ok(pout);
	}
	

}