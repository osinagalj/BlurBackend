package com.tandil.blur.api.inputs;

import com.tandil.blur.persistence.model.Image;

public class ProductInput {
	
    private String name;
	private float price;
	private String description;
	private String categoria;
	private ImageInput image;
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImageInput getImage() {
		return image;
	}

	public void setImage(ImageInput image) {
		this.image = image;
	}




}

