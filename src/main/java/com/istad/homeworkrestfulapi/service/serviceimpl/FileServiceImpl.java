package com.istad.homeworkrestfulapi.service.serviceimpl;

import com.istad.homeworkrestfulapi.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private final Path root = Paths.get("src/main/resources/images");
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        try {
            //get file name
            String fileName = file.getOriginalFilename();
            if (fileName != null &&
                    fileName.contains(".jpg")||
                    fileName.contains(".png")||
                    fileName.contains(".jpeg")
            ){
                fileName = UUID.randomUUID()+ "."+ StringUtils.getFilenameExtension(fileName);

                // create directory if not exist
                if (Files.exists(root)){
                    Files.createDirectories(root);
                }
                // copy file to directory
                Files.copy(file.getInputStream(),root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                return fileName;
            }else {
                return "Can not upload file!!!!";
            }

        }catch (IOException ex){
            throw new IOException("File is not defined");
        }
    }
}
