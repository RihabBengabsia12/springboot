package com.rihab.fabrication.models;

import java.time.LocalDateTime;
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
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false)
    private String etat;
    private LocalDateTime derniereMaintenance;

    @OneToMany(mappedBy = "machineAssignee", cascade = {CascadeType.PERSIST, CascadeType.MERGE},orphanRemoval = true
)
    @JsonIgnore
    private List<Employe> employes = new ArrayList<>();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<OrdreFabrication> getOrdres() {
		return ordres;
	}

	public void setOrdres(List<OrdreFabrication> ordres) {
		this.ordres = ordres;
	}

	public String getEtat() {
		return etat;
	}

	public LocalDateTime getDerniereMaintenance() {
		return derniereMaintenance;
	}

	@OneToMany(mappedBy = "machine", cascade = {CascadeType.PERSIST, CascadeType.MERGE},orphanRemoval= true
)
    @JsonIgnore
    private List<OrdreFabrication> ordres = new ArrayList<>();

	public void setDerniereMaintenance(LocalDateTime derniereMaintenance) {
    this.derniereMaintenance = derniereMaintenance;
}

	public void setEtat(String etat) {
    this.etat = etat;
}
}
