package com.example.demo.controller;

import com.example.demo.model.Categorie;
import com.example.demo.services.CategorieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

   @Autowired
    private CategorieService categorieService;

    @CrossOrigin(origins = "http://localhost:9090")

    @PostMapping("/")
    public ResponseEntity<Categorie> createcategorie(@RequestBody  Categorie categorie ){
        
        categorie =categorieService.createCategorie(categorie);
        return new ResponseEntity<>(categorie, HttpStatus.CREATED) ;

    }
    // GET all categories
    @GetMapping("/")
    public List<Categorie> getAllCategories() {
        return categorieService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable Long id) {
        return categorieService.findCategorieById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategorieById(@PathVariable Long id) {
        categorieService.deleteCategorieById(id);
        return ResponseEntity.ok("Categorie deleted successfully");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
        Categorie updatedCategorie = categorieService.updateCategorieById(id, categorie);
        return ResponseEntity.ok(updatedCategorie);
    }
}
