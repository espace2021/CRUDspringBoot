package com.example.demo.services;

import com.example.demo.model.Article;
import java.util.List;

public interface ArticleService {
    
    List<Article> findAllArticles();
    Article createArticle(Article article);
    Article findArticleById(Long id);
    void deleteArticleById(Long id);
    Article updateArticleById(Long id, Article updatedArticle); 
}
