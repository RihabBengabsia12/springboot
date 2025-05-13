package com.rihab.fabrication.DTO;


import lombok.Data;

@Data
public class ProduitRequestDto {
	   private String nom;
	    private String type;
	    private int stock;
	    private String fournisseur;

}