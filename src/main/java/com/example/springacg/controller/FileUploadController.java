package com.example.springacg.controller;

import com.example.springacg.entity.Files;
import com.example.springacg.service.FileUploadService;
import com.example.springacg.utils.PublicUtils;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(value = "/file")
public class FileUploadController {
    @Autowired
    PublicUtils publicUtils;

    @Autowired
    FileUploadService fileUploadService;

    @Value("${file-save-path}")
    private String fileSavePath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseStatus upload(@RequestParam("files")MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return ResponseStatus.error("上传文件为空!");
        }
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String fileFullName = multipartFile.getOriginalFilename();
        int index = fileFullName.lastIndexOf(".");
        String format = fileFullName.substring(index);
        Files file = new Files();
        file.setFileName(fileName);
        file.setFileFullName(fileFullName);
        file.setFormat(format);
        file.setCreateTime(publicUtils.getTimestamp("yyyy-MM-dd hh:mm:ss"));

        File files = new File(fileSavePath + fileName + format);
        try {

            multipartFile.transferTo(files);

            return fileUploadService.fileUpload(file);
        } catch (Exception e) {
            return ResponseStatus.error(e.getMessage());
        }
    }

}
