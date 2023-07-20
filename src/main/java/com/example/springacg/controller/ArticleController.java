package com.example.springacg.controller;

import com.example.springacg.entity.Article;
import com.example.springacg.service.ArticleService;
import com.example.springacg.utils.ResponseStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
    public ResponseStatus getArticleList(@RequestParam(required = false) String ids,
                                         @RequestParam(required = false) String order,
                                         @RequestParam(required = false) String sort,
                                         @RequestParam(required = false, defaultValue = "0") int pageNo,
                                         @RequestParam(required = false, defaultValue = "30") int pageSize) {
        String[] idList = new String[0];
        if (ids != null) {
            idList = ids.split(",");
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Article> articleList = articleService.getArticleList(idList, order, sort);
        PageInfo pageInfo = new PageInfo<>(articleList);
        return ResponseStatus.ok(articleList, pageInfo);
    }

    @RequestMapping(value = "/getArticleListByIsBanner", method = RequestMethod.GET)
    public ResponseStatus getArticleListByIsBanner(@RequestParam(required = false) Integer isBanner,
                                                   @RequestParam(required = false) Integer isHot) {
        List<Article> list = articleService.getArticleListByIsBanner(isBanner, isHot);

        return ResponseStatus.ok("success", list);
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseStatus addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @RequestMapping(value = "/getArticleListByUserId", method = RequestMethod.GET)
    public ResponseStatus getArticleListByUserId(@RequestParam Integer userId) {
        List<Article> list = articleService.getArticleListByUserId(userId);
        return ResponseStatus.ok("success", list);
    }
}
