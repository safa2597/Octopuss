package tn.esprit.spring.services;

import java.io.IOException;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Fiche;
import tn.esprit.spring.repositories.FichierRepository;


@Service
public class FichierService extends RuntimeException{

@Autowired
    FichierRepository fichierr;

    public Fiche storeFile(MultipartFile fichier) throws FileUploadException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(fichier.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
            System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Fiche dbFile = new Fiche("",fileName, fichier.getContentType(), fichier.getBytes(),null);

            return fichierr.save(dbFile);
        } catch (IOException ex) {
            throw new FileUploadException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public Fiche getfile(String fileId){
    	return fichierr.findById(fileId).orElseThrow(null);
    }
    }
    

