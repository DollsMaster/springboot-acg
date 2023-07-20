package com.example.springacg.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ArticleInfo {
    private Integer id;
    private Integer status;
    private Integer isBanner;
    private Integer isHot;
    private Integer articleId;
    private Integer userId;
    private Integer upvoteNum;
    private Integer downloadNum;
    private Integer examineNum;
    private HashMap property;
}
