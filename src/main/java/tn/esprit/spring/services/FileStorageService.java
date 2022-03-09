package tn.esprit.spring.services;

import java.io.IOException;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.File;
import tn.esprit.spring.repositories.FileRepository;


@Service
public class FileStorageService extends RuntimeException{
	
	@Autowired
    FileRepository filer;

    public File storeFile(MultipartFile file) throws FileUploadException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
            	System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File("",fileName, file.getContentType(), file.getBytes(),null);

            return filer.save(dbFile);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(String fileId) {
        return filer.findById(fileId).orElseThrow(null);
    }
}
