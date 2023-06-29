package com.example.springacg.controller;

import com.example.springacg.entity.Article;
import com.example.springacg.service.ArticleService;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseStatus addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
}
