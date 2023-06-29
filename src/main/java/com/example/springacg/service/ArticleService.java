package com.example.springacg.service;

import com.example.springacg.entity.Article;
import com.example.springacg.mapper.ArticleMapper;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public ResponseStatus addArticle(Article article) {
        article.setStatus(0);
        Integer result = articleMapper.addArticle(article);
        if (result.equals(1)) {
            return ResponseStatus.ok("success");
        } else {
            return ResponseStatus.error("error");
        }
    }
}
