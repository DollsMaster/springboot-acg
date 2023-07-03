package com.example.springacg.mapper;

import com.example.springacg.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    List<Article> getArticleList(@Param("idList") String[] idList);
    Integer addArticle(Article article);
}
