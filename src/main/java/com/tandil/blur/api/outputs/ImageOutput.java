package com.tandil.blur.api.outputs;

public class ImageOutput {
	
    private String name;

    private String extension;

    private String bytes;
    

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

	private Long size;

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


	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
