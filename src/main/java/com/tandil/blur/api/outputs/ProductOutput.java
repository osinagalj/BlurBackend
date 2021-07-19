package com.tandil.blur.api.outputs;


public class ProductOutput {

	private Long id;

	private String name;
	private float price;
	private String description;
	private ImageOutput image;
	
	
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public ImageOutput getImage() {
		return image;
	}
	public void setImage(ImageOutput image) {
		this.image = image;
	}

}
