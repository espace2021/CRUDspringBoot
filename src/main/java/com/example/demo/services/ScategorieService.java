package com.example.demo.services;

import com.example.demo.model.Scategorie;
import java.util.List;

public interface ScategorieService {
    
    List<Scategorie> findAllScategories();
    Scategorie createScategorie(Scategorie categorie);
    Scategorie findScategorieById(Long id);
    void deleteScategorieById(Long id);
    Scategorie updateScategorieById(Long id, Scategorie updatedScategorie); 
}