package com.istad.homeworkrestfulapi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(String serverPath, MultipartFile file) throws IOException;
}
