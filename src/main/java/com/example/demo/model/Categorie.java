package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {
    
    public Categorie() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id; 
    private String nomcategorie; 
    private String imagecategorie; 


    public Long   getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id; 
    }

    public String getNomcategorie() 
    { 
  
         return nomcategorie; 
    } 
  
    public void setNomcategorie( 
        String nomcategorie) 
    { 
  
         this.nomcategorie = nomcategorie; 
    } 
  
    public String getImagecategorie() 
    { 
  
         return imagecategorie; 
    } 
  
    public void setImagecategorie( 
        String imagecategorie) 
    { 
  
         this.imagecategorie = imagecategorie; 
    }

    @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Categorie))
      return false;
    Categorie categorie = (Categorie) o;
    return Objects.equals(this.id, categorie.id) && Objects.equals(this.nomcategorie, categorie.nomcategorie)
        && Objects.equals(this.imagecategorie, categorie.imagecategorie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.nomcategorie, this.imagecategorie);
  }

  @Override
  public String toString() {
    return "Categorie{" + "id=" + this.id + ", nomcategorie='" + this.nomcategorie + '\'' + ", imagecategorie='" + this.imagecategorie + '\'' + '}';
  }

}

