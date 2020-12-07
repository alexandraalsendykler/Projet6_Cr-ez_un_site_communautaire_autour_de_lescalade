package com.openclassrooms.climbing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.climbing.model.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}