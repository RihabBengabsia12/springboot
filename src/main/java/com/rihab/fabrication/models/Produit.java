package com.rihab.fabrication.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 50)
    private String type;
    @Column(nullable = false)
    private int stock;
    @Column(length = 100)
    private String fournisseur;

    @OneToMany(mappedBy = "produit", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },orphanRemoval = true)
    @JsonIgnore
    private List<OrdreFabrication> ordres = new ArrayList<>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<OrdreFabrication> getOrdres() {
		return ordres;
	}

	public void setOrdres(List<OrdreFabrication> ordres) {
		this.ordres = ordres;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}

