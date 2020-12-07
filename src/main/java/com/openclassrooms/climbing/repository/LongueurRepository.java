package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Longueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongueurRepository extends JpaRepository<Longueur, Integer> {

}