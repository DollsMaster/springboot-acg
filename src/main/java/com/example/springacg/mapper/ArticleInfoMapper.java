package com.example.springacg.mapper;

import com.example.springacg.entity.ArticleInfo;

import java.util.List;

public interface ArticleInfoMapper {
    List<ArticleInfo> getArticleInfoListByUserId(Integer userId);
}
