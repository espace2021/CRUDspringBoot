package com.example.demo.implementationServices;

import com.example.demo.model.Article;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleImplemServ implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
  
    @Override
    public List<Article> findAllArticles() {
    return articleRepository.findAll();
      
    }
 
    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

     @Override
    public Article findArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public void deleteArticleById(Long id) {
         articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticleById(Long id, Article updatedArticle) {
       
        Optional<Article> existingArticle = articleRepository.findById(id);
        if (existingArticle.isPresent()) {
            Article article = existingArticle.get();
            article.setDesignation(updatedArticle.getDesignation());
            article.setMarque(updatedArticle.getMarque());
            article.setReference(updatedArticle.getReference());
            article.setQtestock(updatedArticle.getQtestock());
            article.setPrix(updatedArticle.getPrix());
            article.setImageart(updatedArticle.getImageart());
            article.setScategorie(updatedArticle.getScategorie());
            return articleRepository.save(article);
        } else {
            throw new RuntimeException("Article not found");
        }
}

@Override
public List<Article> getByDesignation(String designation) {
    return articleRepository.findByDesignation(designation);
}

@Override
public List<Article> customMethod(Long categorieId) {
    return articleRepository.customMethod(categorieId);
}

@Override
public List<Article> getByPrix(Long prix) {
    return articleRepository.findByPrix(prix);
}

@Override
public Long calculateTotalStock() {
    List<Article> products = articleRepository.findAll();
    return products.stream().mapToLong(Article::getQtestock).sum();
}

@Override
public List<Article> getOutOfStockProducts() {
    return articleRepository.findByQtestock(0);
}

@Override
 public Page<Article> getAllProducts(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return articleRepository.findAll(pageable);
    }


}
