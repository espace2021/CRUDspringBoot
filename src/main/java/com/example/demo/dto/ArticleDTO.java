package com.example.demo.dto;
public class ArticleDTO {
    private Long id;
    
    private String designation;

    private String marque;

    private String reference;

    private Long qtestock;

    private Long prix;

    private String imageart;

    private Long scategorieID;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public Long getQtestock() { return qtestock; }
    public void setQtestock(Long qtestock) { this.qtestock = qtestock; }
    public Long getPrix() { return prix; }
    public void setPrix(Long prix) { this.prix = prix; }
    public String getImageart() { return imageart; }
    public void setImageart(String imageart) { this.imageart = imageart; }
    public Long getScategorieID() { return scategorieID; }
    public void setScategorieID(Long scategorieID) { this.scategorieID = scategorieID; }
}
