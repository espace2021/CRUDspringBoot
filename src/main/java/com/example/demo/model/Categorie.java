package com.example.demo.model;


import java.util.Objects;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import lombok.Getter; 
import lombok.Setter; 
@Getter
@Setter 

@Entity
@Table(name = "categories")
public class Categorie {

    public Categorie() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String nomcategorie; 
    private String imagecategorie; 

      /*   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id; 
    }

    public String getNomcategorie() { 
        return nomcategorie; 
    } 
  
    public void setNomcategorie(String nomcategorie) { 
        this.nomcategorie = nomcategorie; 
    } 
  
    public String getImagecategorie() { 
        return imagecategorie; 
    } 
  
    public void setImagecategorie(String imagecategorie) { 
        this.imagecategorie = imagecategorie; 
    }

*/
  
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nomcategorie, this.imagecategorie);
    }

    
}
