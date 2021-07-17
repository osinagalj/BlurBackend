package com.tandil.blur.api.controllers;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tandil.blur.persistence.model.Product;
import com.tandil.blur.service.product.ProductService;


@RequestMapping("/api/v0/")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;

	@PostMapping(path = "/products")
	public ResponseEntity<Product> registerPersona(@RequestBody Product p){
		Product newP = ps.register(p);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP);
	}	

	@GetMapping(path = "/products")
	public ResponseEntity<List<Product>> getPersonas( ){
		List<Product> list = ps.getAllProducts();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/products/{id}/")
	public ResponseEntity<Product> getPersona(@PathVariable(value = "id") Long id){
		Product p = ps.findProductById(id);		
		return ResponseEntity.ok(p);
	}	
	/*
	@GetMapping(path = "/products/image")
	public String getImg() throws IOException{
		//HashMap<String,String> values = new HashMap<String,String>();
		
			//HashMap<String,Stri
		
		File resource = new ClassPathResource("/resources/static/img.jpg").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
		
//		try (FileReader fileReader = new FileReader("src/main/resources/img.jpg"); 
//			     BufferedReader reader = new BufferedReader(fileReader)) {
//			    String contents = reader.lines()
//			      .collect(Collectors.joining(System.lineSeparator()));
//			}
		System.out.println("Imagen local = " + text);
			//InputStream resourcee = ((MultipartFile) resource).getInputStream();
			//String text = null;
//			try (final Reader reader = new InputStreamReader(resourcee)) {
//				text = CharStreams.toString(reader);
//			}
			//System.out.println(text);

		return "imagen printeada";
	}	
	*/
	
//    @PostMapping("/fileupload")
//    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
//        try {
//            //logger.info("Name= " + name);
//            byte[] image = file.getBytes();
//     
//            int saveImage = ps.saveImage(model);
//            return "ok";
//        } catch (Exception e) {
//            logger.error("ERROR", e);
//            return "error";
//        }
//    }
    
    @GetMapping("/getDetail/{id}")
    public String getDbDetils(@PathVariable String id, Product model) {
        try {
            //logger.info("Id= " + id);
        //	Product imagesObj = myService.getImages(Long.parseLong(id));
            
          //  model.addAttribute("id", imagesObj.getId());
          //  model.addAttribute("name", imagesObj.getName());
           // byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getImage());
          //  model.addAttribute("image", new String(encode, "UTF-8"));
            return "imagedetails";
        } catch (Exception e) {
            //logger.error("Error", e);
          //  model.addAttribute("message", "Error in getting image");
            return "redirect:/";
        }
    }

}