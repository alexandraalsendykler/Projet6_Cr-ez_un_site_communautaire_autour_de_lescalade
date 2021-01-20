package com.openclassrooms.climbing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVoie")
	private Integer id;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="idVoie")
	private List<Longueur> longueurs;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idSecteur")
	private Secteur secteurs;
	
	
	public Secteur getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Secteur secteurs) {
		this.secteurs = secteurs;
	}

	public Integer getNombredepoint() {
		return nombredepoint;
	}

	public void setNombredepoint(Integer nombredepoint) {
		this.nombredepoint = nombredepoint;
	}

	private String nom;
	private String cotation;
	private Float hauteur;
	private Integer nombredepoint;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(List<Longueur> longueurs) {
		this.longueurs = longueurs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Float getHauteur() {
		return hauteur;
	}

	public void setHauteur(Float hauteur) {
		this.hauteur = hauteur;
	}

	public Integer getNombreDePoint() {
		return nombredepoint;
	}

	public void setNombreDePoint(Integer nombredepoint) {
		this.nombredepoint = nombredepoint;
	}

}
