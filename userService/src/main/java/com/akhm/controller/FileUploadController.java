package com.akhm.controller;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.apache.commons.lang.RandomStringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {
	@PostMapping("/fileupload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile ) {
		try {
			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			Long size=multipartFile.getSize();
			Path uploadPath=Paths.get("uploads");
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
				
			}
			String newFileName=RandomStringUtils.randomAlphanumeric(10);
			InputStream inputStream=multipartFile.getInputStream();
			Path filePath=uploadPath.resolve(newFileName+"-"+fileName);
			Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
			return new ResponseEntity<String>(newFileName+"-"+fileName,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	Path fpath=null;
	@GetMapping("/downloadfile/{fname}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("fname") String fileName){
		try {
			Path filePath=Paths.get("uploads/"+fileName);
			if(Files.exists(filePath)) {
				Resource resource=new UrlResource(filePath.toUri());
				String contentType="application/octet-stream";
				String headerValue="attachment:fileName=\""+resource.getFilename()+"\"";
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
				
			} 
			else {
				return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
