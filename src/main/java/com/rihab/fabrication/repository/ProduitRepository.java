package com.rihab.fabrication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.fabrication.models.Produit;

public interface ProduitRepository  extends JpaRepository<Produit, Long>{
	List<Produit> findByType(String type);
	 List<Produit> findByFournisseur(String fournisseur);

}
