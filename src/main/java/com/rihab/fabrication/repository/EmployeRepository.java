package com.rihab.fabrication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.fabrication.models.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>  {
	  List<Employe> findByMachineAssigneeId(Long machineId);
	  List<Employe> findByPoste(String poste);

}
