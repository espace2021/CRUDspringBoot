package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByDesignation(String designation);

 @Query("SELECT a FROM Article a WHERE a.scategorie.categorie.id = :categorieId")
 List<Article> findArticlesByCategorieId(@Param("categorieId") Long categorieId);

    
/*
@Query:
Cette annotation indique qu'il s'agit d'une requête JPQL (Java Persistence Query Language) personnalisée.
Elle permet de spécifier la requête SQL sous forme de chaîne de caractères JPQL.
La requête JPQL SELECT correspond à la valeur du paramètre :categorieId.
@Param("categorieId") indique que le nom du paramètre dans la requête JPQL correspond au nom du paramètre de la méthode findArticlesByCategorieId (categorieId).
 */


  
}
