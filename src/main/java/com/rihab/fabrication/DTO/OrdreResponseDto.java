package com.rihab.fabrication.DTO;


import java.time.LocalDate;

import lombok.Data;
@Data
public class OrdreResponseDto {
	private Long id;
    private String projet;
    public String getMachineNom() {
		return machineNom;
	}
	public void setMachineNom(String machineNom) {
		this.machineNom = machineNom;
	}
	private int quantite;
    private LocalDate date;
    private String etat;
    private String produitNom;
    private String machineNom;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
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
	public String getProduitNom() {
		return produitNom;
	}
	public void setProduitNom(String produitNom) {
		this.produitNom = produitNom;
	}
	public String getEmployeNom() {
		return employeNom;
	}
	public void setEmployeNom(String employeNom) {
		this.employeNom = employeNom;
	}
	private String employeNom;
	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}
	public void setProjet(Object projet2) {
		// TODO Auto-generated method stub
		
	}
	public void setQuantite(Object quantite2) {
		// TODO Auto-generated method stub
		
	}
	public void setDate(Object date2) {
		// TODO Auto-generated method stub
		
	}
	public void setEtat(Object etat2) {
		// TODO Auto-generated method stub
		
	}

}