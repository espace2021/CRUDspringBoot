package com.example.demo.services;

import com.example.demo.model.Categorie;
import java.util.List;

public interface CategorieService {
    
    List<Categorie> findAllCategories();
    Categorie createCategorie(Categorie categorie);
    Categorie findCategorieById(Long id);
    void deleteCategorieById(Long id);
    Categorie updateCategorieById(Long id, Categorie updatedCategorie); 
}