package com.example.demo.controller;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.model.Article;
import com.example.demo.model.Scategorie;
import com.example.demo.services.ArticleService;
import com.example.demo.repositories.ScategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

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
        article.setMarque(articleDTO.getMarque());
        article.setReference(articleDTO.getReference());
        article.setQtestock(articleDTO.getQtestock());
        article.setPrix(articleDTO.getPrix());
        article.setImageart(articleDTO.getImageart());
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
        article.setMarque(articleDTO.getMarque());
        article.setReference(articleDTO.getReference());
        article.setQtestock(articleDTO.getQtestock());
        article.setPrix(articleDTO.getPrix());
        article.setImageart(articleDTO.getImageart());
        article.setScategorie(scategorie);

        Article updatedArticle = articleService.updateArticleById( id, article);
        return ResponseEntity.ok(updatedArticle);
    }

    @GetMapping("/byDesignation/{designation}")
    public List<Article> getArticlesByDesignation(@PathVariable String designation) {
        return articleService.getByDesignation(designation);
    }

    @GetMapping("/byCategorie/{categorieId}")
    public List<Article> customMethod(@PathVariable Long categorieId) {
        return articleService.customMethod(categorieId);
    }

    @GetMapping("/byPrix/{prix}")
    public List<Article> getArticlesByPrix(@PathVariable Long prix) {
        return articleService.getByPrix(prix);
    }

    @GetMapping("/total-stock")
    public long calculateTotalStock() {
        return articleService.calculateTotalStock();
    }

    @GetMapping("/out-of-stock")
    public List<Article> getOutOfStockProducts() {
        return articleService.getOutOfStockProducts();
    }

    @GetMapping("/pagination")
 /* public ResponseEntity<Page<Article>> getProductsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Article> articles = articleService.getAllProducts(page, size);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
*/
public Page<Article> getAllArticles(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "id") String sortBy) {
      return articleService.getAllProducts(page, size, sortBy);

}
  }
