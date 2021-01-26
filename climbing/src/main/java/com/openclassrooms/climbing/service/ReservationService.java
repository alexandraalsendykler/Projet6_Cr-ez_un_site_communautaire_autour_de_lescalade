package com.openclassrooms.climbing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.climbing.model.Reservation;
import com.openclassrooms.climbing.repository.ReservationRepository;



@Service
public class ReservationService implements IReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	

    @Override
    public Optional<Reservation> findById(Integer id) {
    	return reservationRepository.findById(id);
    }
	
}