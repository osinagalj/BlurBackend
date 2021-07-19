package com.tandil.blur.service.image;

import java.util.List;
import com.tandil.blur.persistence.model.Image;

public interface ImageService {
	Image register(Image p);
	List<Image> getAllImages();
	Image findFirst();
	
	Image findByProduct(Long id);
	void deleteAllImagesOfProduct(Long id);
}