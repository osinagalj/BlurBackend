package com.tandil.blur.persistence.mappers;

import com.tandil.blur.api.inputs.ProductInput;
import com.tandil.blur.api.outputs.ProductOutput;
import com.tandil.blur.persistence.model.Image;
import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.utils.Utils;

public class ProductMapper {
	
	
	public static Product map(ProductInput input) {
	
//		Image image = new Image(input.getImage().getName(),
//				input.getImage().getExtension(),
//				Utils.compressBytes(input.getImage().getBytes().getBytes()), //Compress image
//				input.getImage().getSize()
//				);
		
		
		Product product = new Product();
		product.setName(input.getName());
		product.setDescription(input.getDescription());
		product.setPrice(input.getPrice());
		product.setCategoria(input.getCategoria());
		
		//product.setImage(image);
		//image.setProduct(product);
		
		
		return product;
	}
	
	public static ProductOutput map(Product product) {
		
		ProductOutput p = new ProductOutput();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());

		return p;
	}

}
