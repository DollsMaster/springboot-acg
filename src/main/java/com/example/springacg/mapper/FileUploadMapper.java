package com.example.springacg.mapper;

import com.example.springacg.entity.Files;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface FileUploadMapper {
    Integer fileUpload(Files hashMap);
}
