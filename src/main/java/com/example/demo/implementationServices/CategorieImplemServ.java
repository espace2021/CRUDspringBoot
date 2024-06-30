package com.example.demo.implementationServices;

import com.example.demo.model.Categorie;
import com.example.demo.repositories.CategorieRepository;
import com.example.demo.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class CategorieImplemServ implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }
 
    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

     @Override
    public Categorie findCategorieById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categorie not found"));
    }

    @Override
    public void deleteCategorieById(Long id) {
         categorieRepository.deleteById(id);
    }

    @Override
    public Categorie updateCategorieById(Long id, Categorie updatedCategorie) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(id);
        if (existingCategorie.isPresent()) {
            Categorie categorie = existingCategorie.get();
            categorie.setNomcategorie(updatedCategorie.getNomcategorie());
            categorie.setImagecategorie(updatedCategorie.getImagecategorie());
            return categorieRepository.save(categorie);
        } else {
            throw new RuntimeException("Categorie not found");
        }
    }
      
}
