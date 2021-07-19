package com.tandil.blur.persistence.mappers;

import com.tandil.blur.api.outputs.ImageOutput;

import com.tandil.blur.persistence.model.Image;

import com.tandil.blur.utils.Utils;

public class ImageMapper {
	
	public static ImageOutput map(Image img) {
		
		ImageOutput out = new ImageOutput();
		
		out.setName(img.getName());
		out.setExtension(img.getExtension());
		String string = new String(Utils.decompressBytes(img.getBytes()));
		out.setBytes(string);
		out.setSize(img.getSize());

		return out;
	}
}
