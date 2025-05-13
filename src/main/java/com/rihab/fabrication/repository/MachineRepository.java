package com.rihab.fabrication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.fabrication.models.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
	 List<Machine> findByEtat(String etat);

}
