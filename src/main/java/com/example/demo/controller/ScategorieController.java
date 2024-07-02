package com.example.demo.controller;

import com.example.demo.dto.ScategorieDTO;
import com.example.demo.model.Scategorie;
import com.example.demo.model.Categorie;
import com.example.demo.services.ScategorieService;
import com.example.demo.repositories.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scategories")
public class ScategorieController {

    @Autowired
    private ScategorieService scategorieService;

    @Autowired
    private CategorieRepository categorieRepository;

    @CrossOrigin(origins = "http://localhost:9090")
    @PostMapping("/")
    public Scategorie createscategorie(@RequestBody ScategorieDTO scategorieDTO) {
        Categorie categorie = categorieRepository.findById(scategorieDTO.getCategorieID())
                .orElseThrow(() -> new RuntimeException("Categorie not found"));
        
        Scategorie scategorie = new Scategorie();
        scategorie.setNomscategorie(scategorieDTO.getNomscategorie());
        scategorie.setImagescategorie(scategorieDTO.getImagescategorie());
        scategorie.setCategorie(categorie);

        return scategorieService.createScategorie(scategorie);
    }

    @GetMapping("/")
    public List<Scategorie> getAllScategories() {
        return scategorieService.findAllScategories();
    }

    @GetMapping("/{id}")
    public Scategorie getScategorieById(@PathVariable Long id) {
        return scategorieService.findScategorieById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScategorieById(@PathVariable Long id) {
        scategorieService.deleteScategorieById(id);
        return ResponseEntity.ok("Scategorie deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scategorie> updateScategorie(@PathVariable Long id, @RequestBody ScategorieDTO scategorieDTO) {
        Categorie categorie = categorieRepository.findById(scategorieDTO.getCategorieID())
                .orElseThrow(() -> new RuntimeException("Categorie not found"));

        Scategorie scategorie = new Scategorie();
        scategorie.setNomscategorie(scategorieDTO.getNomscategorie());
        scategorie.setImagescategorie(scategorieDTO.getImagescategorie());
        scategorie.setCategorie(categorie);

        Scategorie updatedScategorie = scategorieService.updateScategorieById( id, scategorie);
        return ResponseEntity.ok(updatedScategorie);
    }
}
