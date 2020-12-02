package com.openclassrooms.climbing.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSite")
	private Integer id;
	
	private String nom;
	
	private String description;
	
	private String coordonneesgps;
	
	private Boolean officiel;
	
	@OneToMany
	@JoinColumn(name = "idSite")
	private List<Commentaire> commentaires;
	
	@OneToMany
	@JoinColumn(name = "idSite")
	private List<Secteur> secteurs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getcoordonneesgps() {
		return coordonneesgps;
	}

	public void setCoordonneesgps(String coordonneesgps) {
		this.coordonneesgps = coordonneesgps;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoordonneesgps() {
		return coordonneesgps;
	}

	public void setCoordonneesGps(String coordonneesgps) {
		this.coordonneesgps = coordonneesgps;
	}

	public Boolean getOfficiel() {
		return officiel;
	}

	public void setOfficiel(Boolean officiel) {
		this.officiel = officiel;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}
