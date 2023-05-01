package com.istad.homeworkrestfulapi.controller;

import com.istad.homeworkrestfulapi.model.FileResponse;
import com.istad.homeworkrestfulapi.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FileUploadController {
    private final FileService fileService;

    //upload file
    @PostMapping(value = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {
        String fileName = fileService.uploadFile(file);
        return ResponseEntity.ok(new FileResponse<>(fileName,"Successfully upload file", 201
        ));
    }
}
