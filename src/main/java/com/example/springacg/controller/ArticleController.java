package com.example.springacg.controller;

import com.example.springacg.entity.Article;
import com.example.springacg.service.ArticleService;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    public ResponseStatus getArticleList(@RequestParam String ids) {
        String[] idList = ids.split(",");
        return articleService.getArticleList(idList);
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseStatus addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
}
