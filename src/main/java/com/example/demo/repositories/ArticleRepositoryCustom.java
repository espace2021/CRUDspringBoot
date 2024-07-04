package com.example.demo.repositories;

import java.util.List;
import com.example.demo.model.Article;

public interface ArticleRepositoryCustom {
    List<Article> customMethod(Long categorieId);
}
