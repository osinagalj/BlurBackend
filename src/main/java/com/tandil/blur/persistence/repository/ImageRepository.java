package com.tandil.blur.persistence.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tandil.blur.persistence.model.Image;

@RepositoryRestResource(exported = false)
public interface ImageRepository extends PagingAndSortingRepository<Image, Long>{
	Image findByName(String name);
	Image findProductById(Long id);
	
}
