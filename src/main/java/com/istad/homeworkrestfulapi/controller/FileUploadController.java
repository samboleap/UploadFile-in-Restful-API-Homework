package com.istad.homeworkrestfulapi.controller;

import com.istad.homeworkrestfulapi.model.FileResponse;
import com.istad.homeworkrestfulapi.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploading")
public class FileUploadController {
    private FileService fileService;
    @Value("${server.path}")
    String serverPath;

    //upload file
    @PostMapping( "/file")
    public ResponseEntity<?> uploadFile(@RequestParam("upload") MultipartFile file) throws IOException {
        String fileName = null;
        try {
            fileName = this.fileService.uploadFile(serverPath,file);
        }catch (Exception ex){
            return new ResponseEntity<>(new FileResponse("File upload is not defined!!!!",null), HttpStatus.OK);

        }
        return new ResponseEntity<>(new FileResponse(fileName,"Successfully upload file"),HttpStatus.OK);
    }
}
