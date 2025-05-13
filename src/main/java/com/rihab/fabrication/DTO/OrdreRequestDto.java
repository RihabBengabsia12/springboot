package com.rihab.fabrication.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrdreRequestDto {
	private String projet;
    private int quantite;
    public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Long getProduitId() {
		return produitId;
	}
	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	public Long getEmployeId() {
		return employeId;
	}
	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}
	private LocalDate date;
    public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	private String etat;

    private Long produitId;
    private Long machineId;
    private Long employeId;
}
