package com.rest.api.interview.preapration.services;

import java.util.Objects;

//FileServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.rest.api.interview.preapration.exception.InvalidFileSizeException;
import com.rest.api.interview.preapration.model.FileEntity;
import com.rest.api.interview.preapration.repositroy.FileRepository;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;

	@Override
	public void uploadFile(MultipartFile file) {

		try {
			// Calculate file size
			long fileSize = file.getSize();

			// Get file name
			String fileName = Objects.requireNonNull(file.getOriginalFilename());

			// Read file content as byte array
			byte[] fileContent = file.getBytes();

			// Store information in the database
			FileEntity fileEntity = new FileEntity();
			fileEntity.setFileName(fileName);
			fileEntity.setFileSize(fileSize);
			fileEntity.setFileContent(fileContent);
			if (fileEntity.getFileSize() <= 307200) {
				fileRepository.save(fileEntity);
			} else {
				throw new InvalidFileSizeException(
						"File size must be lower than 300kb or equals to 300kb try again with reducing the size ");
			}

		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
		}
	}

	@Override
	public byte[] getPdfFileContent(Long fileId) {
		FileEntity fileEntity = fileRepository.findById(fileId).orElse(null);

		if (fileEntity != null && fileEntity.getFileContent() != null) {
			return fileEntity.getFileContent();
		} else {
			// Handle not found or empty file content
			return null;
		}
	}

}
