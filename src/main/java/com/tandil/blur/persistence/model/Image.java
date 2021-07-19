package com.tandil.blur.persistence.model;

import javax.persistence.CascadeType; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "image_table")
public class Image {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name")
    private String name;

    @Column(name = "extension")
    private String extension;

	@ManyToOne //The Many refers to Cow and the One to Herd
	@JoinColumn(name = "product_id", referencedColumnName = "id" )
	private Product product;	
    
    
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "image_id")
//    private Product product;
//    
//    public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Lob
    @Column(name = "bytes") // length = 1000
    private byte[] bytes;
 
	//image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "size") // length = 1000
    private Long size;

    public Image() {
        super();
    }

    public Image(String name, String extension, byte[] bytes, Long size) {
        this.name = name;
        this.extension = extension;
        this.bytes = bytes;
        this.size = size;
    }
    
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

	   
    public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}



}