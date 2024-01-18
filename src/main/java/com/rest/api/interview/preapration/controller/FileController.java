package com.rest.api.interview.preapration.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

//FileController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.api.interview.preapration.services.FileService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/files")    
public class FileController {

 @Autowired
 private FileService fileService;

 
 @GetMapping("/welcome")
  public String welcome() {
	  return "Hello Vikas and Nandu, How are you";
  }
 
 //http://localhost:8080/files/upload
 @PostMapping("/upload")
 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
	 
     fileService.uploadFile(file);

     return ResponseEntity.ok("File uploaded successfully!");
 }
 
 @GetMapping("/pdf/{fileId}")
 public ResponseEntity<InputStreamResource> getPdfFile(@PathVariable Long fileId) throws IOException {
     byte[] fileContent = fileService.getPdfFileContent(fileId);

     if (fileContent != null) {
         // Create an InputStreamResource from the file content
         ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContent);

         // Set the response headers
         return ResponseEntity
                 .ok()
                 .header("Content-disposition", "inline; filename=file.pdf")
                 .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                 .body(new InputStreamResource(inputStream));
     } else {
         // Handle not found or empty file content
         return ResponseEntity.notFound().build();
     }
 }
 
}
