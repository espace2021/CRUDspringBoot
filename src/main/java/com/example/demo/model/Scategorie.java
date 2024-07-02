package com.example.demo.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scategories")
public class Scategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scategorie_generator")
    private Long id;
    
    private String nomscategorie;

    private String imagescategorie;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "categorieID", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Categorie categorie;


    // Constructors, getters, and other methods

    public Scategorie() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomscategorie() {
        return nomscategorie;
    }

    public void setNomscategorie(String nomscategorie) {
        this.nomscategorie = nomscategorie;
    }

    public String getImagescategorie() {
        return imagescategorie;
    }

    public void setImagescategorie(String imagescategorie) {
        this.imagescategorie = imagescategorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

 
  }

