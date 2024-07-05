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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
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

 
  }

