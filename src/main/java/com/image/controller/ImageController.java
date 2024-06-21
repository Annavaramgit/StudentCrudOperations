package com.image.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import com.image.entity.ImageEntity;
import com.image.service.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	//save the image or file
	@PostMapping("/saveimage")
	public String saveImage(@RequestParam("file") MultipartFile file,String description) throws IOException, SerialException, SQLException {
		
		
		return imageService.saveImage(file, description);
	}
	
	//get particular  images based on id
	@GetMapping("/get/{id}")
	public ResponseEntity<byte[]> getByNameImage(@PathVariable("id") int id) throws SQLException {

		List<ImageEntity> imgById = imageService.getImage(id);

		if (!imgById.isEmpty()) {
			ByteArrayOutputStream ab = new ByteArrayOutputStream();
			try {
				for (ImageEntity image : imgById) {

					byte[] bytes = image.getImage().getBytes(1, (int) image.getImage().length());
					ab.write(bytes);
				}
				byte[] allImageData = ab.toByteArray();
				return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
						.contentType(MediaType.IMAGE_PNG).body(allImageData);
				
				

			} catch (IOException e) { 
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} else {
			return ResponseEntity.notFound().build();
		
		}
	}
	
	
	
	
	//get all images
	@GetMapping("/getall")
    public ResponseEntity<List<ResponseEntity<byte[]>>> getAllImages() throws SQLException, IOException {
        List<ImageEntity> allImages = imageService.getAllImages();
        if (!allImages.isEmpty()) {
            List<byte[]> imageBytesList = new ArrayList<>();
            List<ResponseEntity<byte[]>> response =  new ArrayList<>();
            for (ImageEntity image : allImages) {
                byte[] imageData = image.getImage().getBytes(1, (int) image.getImage().length());
               response.add(this.showingMethod(imageData));
            }

            return ResponseEntity.ok().body(response);
                    
                  
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	public ResponseEntity<byte[]> showingMethod(byte[] bytes){
		ByteArrayOutputStream ab = new ByteArrayOutputStream();
		
		
		try {
			ab.write(bytes);
		} catch (IOException e) {

			e.printStackTrace();
		}
		byte[] allImageData = ab.toByteArray();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
				.contentType(MediaType.IMAGE_JPEG).body(allImageData);
	}
	
	
	




}
