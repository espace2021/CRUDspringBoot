package com.example.demo.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import com.example.demo.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> customMethod(Long categorieId) {
        String jpql = "SELECT a FROM Article a WHERE a.scategorie.categorie.id = :categorieId";
        TypedQuery<Article> query = entityManager.createQuery(jpql, Article.class);
        query.setParameter("categorieId", categorieId);
        return query.getResultList();
    }
}
