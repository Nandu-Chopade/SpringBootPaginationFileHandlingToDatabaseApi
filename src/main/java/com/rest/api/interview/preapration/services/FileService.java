package com.rest.api.interview.preapration.services;

import org.springframework.web.multipart.MultipartFile;

//FileService.java
public interface FileService {

 void uploadFile(MultipartFile file);
 byte[] getPdfFileContent(Long fileId);
}
