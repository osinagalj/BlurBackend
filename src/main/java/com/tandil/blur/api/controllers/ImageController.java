package com.tandil.blur.api.controllers;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tandil.blur.api.inputs.ImageInput;
import com.tandil.blur.persistence.model.Image;
import com.tandil.blur.persistence.repository.ImageRepository;
import com.tandil.blur.utils.Utils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

//    @PostMapping("/upload")
//    public ResponseEntity<Image> uploadImage(@RequestBody ImageInput file) throws IOException {
//    	
//    	System.out.println("EL FILE CONTENIDO = ");
//    	System.out.println(file.toString());
//    	System.out.println("TIPO = "+file.getExtension());
//    	System.out.println("nomre  = "+file.getName());
//    	
//    	
//        //log.info("Original Image Byte Size - " + file.getBytes().length);
//        Image img = new Image(file.getName(), file.getExtension(),
//        		Utils.compressBytes(file.getBytes().getBytes()),(long) 2);
//        Image saved = imageRepository.save(img);
//        
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(saved.getId())
//				.toUri();
//        
//        return ResponseEntity.created(location).body(img);
//    }
    
    /*
    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
    	
    	System.out.println("EL FILE CONTENIDO = ");
    	System.out.println(file.toString());
    	System.out.println("TIPO = "+file.getContentType());
    	System.out.println("nomre  = "+file.getOriginalFilename());
    	
    	
    	
        //log.info("Original Image Byte Size - " + file.getBytes().length);
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
        		Utils.compressBytes(file.getBytes()));
        Image saved = imageRepository.save(img);
        
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved.getId())
				.toUri();
        
        return ResponseEntity.created(location).body(img);
    }
*/
//    @GetMapping(path = {"/get/{imageName}"})
//    public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
//
//        //Image retrievedImage = imageRepository.findByName(imageName);
//        
//    	 List<Image> ej = (List<Image>) imageRepository.findAll();
//    	 Image retrievedImage = ej.get(0);
//        Image img = new Image(retrievedImage.getName(), retrievedImage.getExtension(),
//                Utils.decompressBytes(retrievedImage.getBytes()),(long) 2);
//                
//        return img;
//    }
    
    
}