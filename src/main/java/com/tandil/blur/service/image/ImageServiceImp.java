package com.tandil.blur.service.image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tandil.blur.persistence.model.Image;
import com.tandil.blur.persistence.repository.ImageRepository;

@Service
public class ImageServiceImp implements ImageService{

	
	@Autowired
	ImageRepository pr;

	
	@Override
	public Image findByProduct(Long id){
		return pr.findProductById(id);

		//return images;
	}
	
	
	@Override
	public void deleteAllImagesOfProduct(Long id) {
		Iterator<Image> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Image i = it.next();
			if(i.getId() == id) {
				pr.delete(i);
			}
		}	
	}
	
	@Override
	public Image register(Image p) {
		return pr.save(p);
	}

	@Override
	public List<Image> getAllImages(){
		List<Image> images = new ArrayList<Image>();
		Iterator<Image> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Image img = it.next();
			images.add(img);
		}
		return images;
	}
	
	@Override
	public Image findFirst(){
		Iterator<Image> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Image img = it.next();
			return img;
		}
		return null;
	}
	
}
