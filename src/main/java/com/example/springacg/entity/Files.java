package com.example.springacg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Files {
    private Long id;
    private String fileName;
    private String fileFullName;
    private String format;
    private String createTime;
}
