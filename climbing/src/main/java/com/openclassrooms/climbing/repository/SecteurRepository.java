package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

}