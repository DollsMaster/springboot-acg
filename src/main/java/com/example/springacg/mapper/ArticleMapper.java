package com.example.springacg.mapper;

import com.example.springacg.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    List<Article> getArticleList();
    Integer addArticle(Article article);
}
