package com.example.demo.implementationServices;

import com.example.demo.model.Scategorie;
import com.example.demo.repositories.ScategorieRepository;
import com.example.demo.services.ScategorieService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ScategorieImplemServ implements ScategorieService {

    @Autowired
    private ScategorieRepository scategorieRepository;
  
    @Override
    public List<Scategorie> findAllScategories() {
    return scategorieRepository.findAll();
      
    }
 
    @Override
    public Scategorie createScategorie(Scategorie scategorie) {
        return scategorieRepository.save(scategorie);
    }


     @Override
    public Scategorie findScategorieById(Long id) {
        return scategorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scategorie not found"));
    }

    @Override
    public void deleteScategorieById(Long id) {
         scategorieRepository.deleteById(id);
    }

    @Override
    public Scategorie updateScategorieById(Long id, Scategorie updatedScategorie) {
       
        Optional<Scategorie> existingScategorie = scategorieRepository.findById(id);
        if (existingScategorie.isPresent()) {
            Scategorie scategorie = existingScategorie.get();
            scategorie.setNomscategorie(updatedScategorie.getNomscategorie());
            scategorie.setImagescategorie(updatedScategorie.getImagescategorie());
            scategorie.setCategorie(updatedScategorie.getCategorie());
            return scategorieRepository.save(scategorie);
        } else {
            throw new RuntimeException("S/Categorie not found");
        }
}
}