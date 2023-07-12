package com.example.springacg.service;

import com.example.springacg.entity.Article;
import com.example.springacg.mapper.ArticleMapper;
import com.example.springacg.utils.PublicUtils;
import com.example.springacg.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    PublicUtils publicUtils;

    public List<Article> getArticleList(String[] idList, String order, String srot) {
        List<Article> articleList = articleMapper.getArticleList(idList, order, srot);
        return articleList;
    }

    public ResponseStatus addArticle(Article article) {
        article.setStatus(0);
        article.setCreateTime(publicUtils.getTimestamp("yyyy-MM-dd HH:mm:ss"));
        Integer result = articleMapper.addArticle(article);
        if (result.equals(1)) {
            return ResponseStatus.ok("success");
        } else {
            return ResponseStatus.error("error");
        }
    }

    public List<Article> getArticleListByIsBanner(Integer isBanner, Integer hot) {
        return articleMapper.getArticleListByIsBanner(isBanner, hot);
    }
}
