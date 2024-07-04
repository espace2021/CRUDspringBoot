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
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_generator")
    private Long id;
    
    private String designation;

    private String marque;

    private String reference;

    private Long qtestock;

    private Long prix;

    private String imageart;

    
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "scategorieID", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Scategorie scategorie;


    // Constructors, getters, and other methods

    public Article() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getQtestock() {
        return qtestock;
    }

    public void setQtestock(Long qtestock) {
        this.qtestock = qtestock;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getImageart() {
        return imageart;
    }

    public void setImageart(String imageart) {
        this.imageart = imageart;
    }

    public Scategorie getScategorie() {
        return scategorie;
    }

    public void setScategorie(Scategorie scategorie) {
        this.scategorie = scategorie;
    }

 
  }

