package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    //liste pour une désigantion donnée
    public List<Article> findByDesignation(String designation);

    //liste pour une catégorie donnée
    public List<Article> customMethod(Long categorieId);

    //liste ayant un prix max
    @Query("SELECT a FROM Article a WHERE a.prix <= :prix")
    List<Article> findByPrix(@Param("prix") Long prix);
 
}
