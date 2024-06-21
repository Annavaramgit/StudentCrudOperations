package com.image.service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image.entity.ImageEntity;
import com.image.repository.ImageRepository;
@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	//saves image or file in the db
	public String saveImage(MultipartFile file,String description) throws IOException, SerialException, SQLException {
		
		ImageEntity imageEntity = new ImageEntity();
		 // Validate file content type
        String contentType = file.getContentType();
        if (!contentType.equals("image/jpeg") && !contentType.equals("application/pdf")) {
            throw new IllegalArgumentException("Invalid file type. Only JPG and PDF are allowed.");
        }

        // Validate file extension
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || (!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".jpeg") && !originalFilename.endsWith(".pdf"))) {
            throw new IllegalArgumentException("Invalid file extension. Only .jpg, .jpeg, and .pdf are allowed.");
        }
		
		
		imageEntity.setDescription(description);
		
		 imageEntity.setImage(new javax.sql.rowset.serial.SerialBlob(file.getBytes()));
		imageRepository.save(imageEntity);
		return "saved..";
		
	}
	public List<ImageEntity> getImage(int id) {

		List<ImageEntity> imeages = imageRepository.findById(id);
		
		
		return imeages ;

		}
	
	
	
	  // Get all images
    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }
	
	}
	


