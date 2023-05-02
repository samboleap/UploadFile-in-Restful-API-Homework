package com.istad.homeworkrestfulapi.service.serviceimpl;

import com.istad.homeworkrestfulapi.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(String serverPath, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String randoms = UUID.randomUUID().toString();
        if (fileName !=null &&
                fileName.contains(".png")||
                fileName.contains("jpg")||
                fileName.contains(".jpeg")||
                fileName.contains(".java")
        ){
            String name=randoms.concat(fileName.substring(fileName.lastIndexOf("")));
            String root = serverPath + File.separator + name;
            File Image=new File(serverPath);
            if (!Image.exists()){
                Image.createNewFile();
            }
            Files.copy(file.getInputStream(),Paths.get(root));
            return fileName;
        }else return "Can not upload File!!!";
    }
}
