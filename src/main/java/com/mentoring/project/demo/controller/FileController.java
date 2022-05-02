package com.mentoring.project.demo.controller;

import com.mentoring.project.demo.model.FileRequest;
import com.mentoring.project.demo.service.FileRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/ms/mentoring-demo/", produces = {(MediaType.APPLICATION_JSON_VALUE)})
public class FileController {

    @Autowired
    FileRequestService fileRequestService;

    @PostMapping(value = "file/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("File") MultipartFile file, @RequestParam("id_request") Long idRequest) {
        try {
            fileRequestService.uploadFile(idRequest, file);

            return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

    @GetMapping("file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<FileRequest> fileOptional = fileRequestService.getFile(id);

        if (fileOptional.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }

        FileRequest file = fileOptional.get();
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
            .contentType(MediaType.valueOf(file.getContentType()))
            .body(file.getData());
    }
}
