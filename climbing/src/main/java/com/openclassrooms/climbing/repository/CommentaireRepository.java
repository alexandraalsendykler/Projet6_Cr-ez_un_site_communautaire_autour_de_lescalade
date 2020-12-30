package com.openclassrooms.climbing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.climbing.model.Commentaire;
import com.openclassrooms.climbing.model.Utilisateur;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	

}