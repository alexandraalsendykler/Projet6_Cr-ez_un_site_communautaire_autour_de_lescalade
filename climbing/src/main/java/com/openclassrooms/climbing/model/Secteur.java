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
public class Secteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSecteur")
	private Integer id;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idSecteur")
	private List<Voie> voies;
	

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idSite")
	private Site sites;

	private String nom;

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Site getSite() {
		return sites;
	}

	public void setSite(Site sites) {
		this.sites = sites;
	}

}
