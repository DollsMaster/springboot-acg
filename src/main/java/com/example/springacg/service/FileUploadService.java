package com.example.springacg.service;

import com.example.springacg.entity.Files;
import com.example.springacg.mapper.FileUploadMapper;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FileUploadService {
    @Autowired
    FileUploadMapper fileUploadMapper;
    public ResponseStatus fileUpload(Files file) {
        try {
            Integer result = fileUploadMapper.fileUpload(file);
            return ResponseStatus.ok("success", file);
        } catch (RuntimeException runtimeException) {
            return ResponseStatus.error(runtimeException.getMessage());
        }
    }
}
