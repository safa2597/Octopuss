package tn.esprit.spring.services;

import java.io.IOException;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.CV;
import tn.esprit.spring.repositories.CVRepository;


@Service
public class CVService extends RuntimeException{

@Autowired
    CVRepository CVr;

    public CV storeFile(MultipartFile CV) throws FileUploadException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(CV.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
            System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
            }

            CV dbFile = new CV("",fileName, CV.getContentType(), CV.getBytes(),null);

            return CVr.save(dbFile);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public CV getfile(String fileId){
    	return CVr.findById(fileId).orElseThrow(null);
    }
    }