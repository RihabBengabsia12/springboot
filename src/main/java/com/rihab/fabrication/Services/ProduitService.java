package com.rihab.fabrication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.fabrication.repository.ProduitRepository;
import com.rihab.fabrication.models.Produit;

@Service
public class ProduitService {
	
@Autowired
private  ProduitRepository produitRepository;


public List<Produit> getAllProduits() {
    return produitRepository.findAll();
}

public Produit getProduitById(Long id) {
    return produitRepository.findById(id).orElse(null);
}

public Produit saveProduit(Produit produit) {
    return produitRepository.save(produit);
}

public void deleteProduit(Long id) {
    produitRepository.deleteById(id);
}

public List<Produit> getProduitsByType(String type) {
    return produitRepository.findByType(type);
}


}

