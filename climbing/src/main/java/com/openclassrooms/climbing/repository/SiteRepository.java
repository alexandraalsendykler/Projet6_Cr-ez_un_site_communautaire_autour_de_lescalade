package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Site;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

	List <Site> findByNomContaining(String nom);
}