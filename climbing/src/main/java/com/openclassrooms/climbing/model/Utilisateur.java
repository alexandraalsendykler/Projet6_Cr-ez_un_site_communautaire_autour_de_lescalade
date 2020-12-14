package com.openclassrooms.climbing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	// attributs utilisateur
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUtilisateur") // permet d'écrire
	private Integer id;
	private String pseudo;
	private Boolean membre;
	private String email;
	private String motdepasse;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Boolean getMembre() {
		return membre;
	}

	public void setMembre(Boolean membre) {
		this.membre = membre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
