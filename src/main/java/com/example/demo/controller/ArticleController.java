package com.example.demo.controller;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.model.Article;
import com.example.demo.model.Scategorie;
import com.example.demo.services.ArticleService;
import com.example.demo.repositories.ScategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ScategorieRepository scategorieRepository;

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping("/")
    public Article createarticle(@RequestBody ArticleDTO articleDTO) {
        Scategorie scategorie = scategorieRepository.findById(articleDTO.getScategorieID())
                .orElseThrow(() -> new RuntimeException("Scategorie not found"));
        
        Article article = new Article();
        article.setDesignation(articleDTO.getDesignation());
       // TODO: le reste à compléter
        article.setScategorie(scategorie);

        return articleService.createArticle(article);
    }

    @GetMapping("/")
    public List<Article> getAllArticles() {
        return articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.ok("Article deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        Scategorie scategorie = scategorieRepository.findById(articleDTO.getScategorieID())
                .orElseThrow(() -> new RuntimeException("Scategorie not found"));

        Article article = new Article();
        article.setDesignation(articleDTO.getDesignation());
        // TODO: le reste à compléter
        article.setScategorie(scategorie);

        Article updatedArticle = articleService.updateArticleById( id, article);
        return ResponseEntity.ok(updatedArticle);
    }
}
