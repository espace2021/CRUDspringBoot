package com.example.demo.dto;

public class ScategorieDTO {
    private Long id;
    private String nomscategorie;
    private String imagescategorie;
    private Long categorieID;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomscategorie() { return nomscategorie; }
    public void setNomscategorie(String nomscategorie) { this.nomscategorie = nomscategorie; }
    public String getImagescategorie() { return imagescategorie; }
    public void setImagescategorie(String imagescategorie) { this.imagescategorie = imagescategorie; }
    public Long getCategorieID() { return categorieID; }
    public void setCategorieID(Long categorieID) { this.categorieID = categorieID; }
}
