package com.openclassrooms.climbing.service;

import java.util.Optional;

import com.openclassrooms.climbing.model.Reservation;


public interface IReservationService {
	Optional<Reservation> findById(Integer id) ;
}
