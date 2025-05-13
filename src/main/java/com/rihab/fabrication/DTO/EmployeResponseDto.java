package com.rihab.fabrication.DTO;


import lombok.Data;

@Data
public class EmployeResponseDto {
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
		public Long getMachineId() {
			return machineId;
		}
		public void setMachineId(Long machineId) {
			this.machineId = machineId;
		}
		public String getMachineNom() {
			return machineNom;
		}
		public void setMachineNom(String machineNom) {
			this.machineNom = machineNom;
		}
		private String nom;
	    private String poste;
	    private Long machineId;
	    private String machineNom;

}

