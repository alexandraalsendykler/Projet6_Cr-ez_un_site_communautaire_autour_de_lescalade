package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Reservation;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.model.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	List <Reservation> findByUtilisateur(Utilisateur utilisateur);
	
}
