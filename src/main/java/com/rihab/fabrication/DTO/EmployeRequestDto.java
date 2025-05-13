package com.rihab.fabrication.DTO;

import lombok.Data;

@Data
public class EmployeRequestDto {
	 private String nom;
	 public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	private String poste;
	 private Long machineId;
}

