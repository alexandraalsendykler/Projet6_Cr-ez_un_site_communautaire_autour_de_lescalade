package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

	List<Utilisateur> findByEmail(String email); 
	List<Utilisateur> findById(int id);
}