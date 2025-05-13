package com.rihab.fabrication.models;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public List<OrdreFabrication> getOrdres() {
		return ordres;
	}

	public void setOrdres(List<OrdreFabrication> ordres) {
		this.ordres = ordres;
	}

	public Machine getMachineAssignee() {
		return machineAssignee;
	}

	@Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 50)
    private String poste;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    @JsonIgnore
    private Machine machineAssignee;

    @OneToMany(mappedBy = "employe", cascade =CascadeType.PERSIST,orphanRemoval = true)
    @JsonIgnore
    private List<OrdreFabrication> ordres = new ArrayList<>();

	public void setMachineAssignee(Machine machine) {
		// TODO Auto-generated method stub
		
	}
}
