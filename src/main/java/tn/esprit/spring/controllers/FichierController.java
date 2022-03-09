package tn.esprit.spring.controllers;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entities.Fiche;
import tn.esprit.spring.entities.Uploadfichier;
import tn.esprit.spring.services.FichierService;

@RestController
public class FichierController {

    private static final Logger logger = LoggerFactory.getLogger(FichierController.class);

    @Autowired
    private FichierService fs;

    @PostMapping("/uploadFichier")
    public Uploadfichier uploadfichier(@RequestParam("fiche") MultipartFile fiche) throws FileUploadException {
        Fiche dbFile = fs.storeFile(fiche);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFichier/")
                .path(dbFile.getIdFiche())
                .toUriString();

        return new Uploadfichier(dbFile.getNomf(), fileDownloadUri,
                fiche.getContentType(), fiche.getSize());
    }

    @GetMapping("/downloadFichier/{fileId}")
    public ResponseEntity<Resource> downloadFichier(@PathVariable String fileId) {
        // Load file from database
        Fiche dbFile = fs.getfile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getTypef()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNomf() + "\"")
                .body(new ByteArrayResource(dbFile.getDataf()));
    }

}
