package com.rihab.fabrication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.fabrication.models.OrdreFabrication;

public interface OrdreFabricationRepository extends JpaRepository<OrdreFabrication, Long> {
	    List<OrdreFabrication> findByEtat(String etat);
	    List<OrdreFabrication> findByMachineId(Long machineId);
	    List<OrdreFabrication> findByEmployeId(Long employeId);
	    List<OrdreFabrication> findByProduitId(Long produitId);
}

