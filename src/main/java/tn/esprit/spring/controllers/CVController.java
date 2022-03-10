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

import tn.esprit.spring.entities.CV;
import tn.esprit.spring.entities.Uploadcv;
import tn.esprit.spring.services.CVService;

@RestController
public class CVController {

    private static final Logger logger = LoggerFactory.getLogger(CVController.class);

    @Autowired
    private CVService cs;

    @PostMapping("/uploadCV")
    public Uploadcv uploadCV(@RequestParam("CV") MultipartFile CV) throws FileUploadException {
        CV dbFile = cs.storeFile(CV);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadCV/")
                .path(dbFile.getIdC())
                .toUriString();

        return new Uploadcv(dbFile.getNomC(), fileDownloadUri,
                CV.getContentType(), CV.getSize());
    }

    @GetMapping("/downloadCV/{fileId}")
    public ResponseEntity<Resource> downloadCV(@PathVariable String fileId) {
        // Load file from database
        CV dbFile = cs.getfile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getTypeC()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getNomC() + "\"")
                .body(new ByteArrayResource(dbFile.getDataC()));
    }

}




