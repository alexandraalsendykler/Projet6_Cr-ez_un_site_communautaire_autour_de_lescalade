package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Voie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Integer> {

	List<Voie> findBySecteurs(Secteur secteur);
}