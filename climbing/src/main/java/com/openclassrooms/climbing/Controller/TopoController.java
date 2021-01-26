package com.openclassrooms.climbing.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.climbing.model.Reservation;
import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.model.Utilisateur;
import com.openclassrooms.climbing.repository.ReservationRepository;
import com.openclassrooms.climbing.repository.TopoRepository;
import com.openclassrooms.climbing.service.IReservationService;
import com.openclassrooms.climbing.service.ISiteService;
import com.openclassrooms.climbing.service.ITopoService;

@Controller

public class TopoController {

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private ITopoService topoService;
	@Autowired
	private IReservationService reservationService;
	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping(value = "touslestopos")
	public String touslestopos(Model model) {
		Iterable<Topo> topo = topoRepository.findAll();
		model.addAttribute("topos", topo);
		return ("touslestopos");
	}

	@RequestMapping(path = "/topo/{id}")
	public String site(Model model, @PathVariable("id") Integer id) {
		Optional<Topo> topo = topoService.findById(id);
		model.addAttribute("topos", topo.get());
		return ("topo");
	}

	@RequestMapping(path = "/reserveruntopo/{id}")
	public String reserveruntopo(Model model, @PathVariable("id") Integer id) {
		Optional<Topo> topo = topoService.findById(id);
		model.addAttribute("topos", topo.get());
		return ("reserveruntopo");
	}

	@RequestMapping(path = "/demandedereservation/{id}")
	public String demandedereservation(Model model, @PathVariable("id") Integer id, HttpSession session) {
		Optional<Topo> topo = topoService.findById(id);
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("user");
		Reservation reservation = new Reservation();
		reservation.setTopos(topo.get());
		reservation.setUtilisateur(connectedUser);
		reservation.setStatut("demande");
		reservationRepository.save(reservation);
		return ("redirect:/touslestopos");
	}
	@RequestMapping(path="/confirmerreservation/{id}")
	public String confirmerreservation(Model model, @PathVariable("id") Integer id) {
		Optional<Reservation> reservations= reservationService.findById(id);
		Reservation reservation = reservations.get();
		reservation.setStatut("confirmer");
		reservationRepository.save(reservation);
		Topo topo = reservation.getTopos();
		topo.setDisponibilite(false);
		topoRepository.save(topo);
		return ("confirmerreservation");
	}
	
}
