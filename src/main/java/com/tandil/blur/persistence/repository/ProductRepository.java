package com.tandil.blur.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tandil.blur.persistence.model.Product;


@RepositoryRestResource(exported = false)
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
	Product findByName(String name);
	Product findProductById(Long id);
	
}
