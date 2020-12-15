package com.openclassrooms.climbing.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.openclassrooms.climbing.model.Commentaire;
import com.openclassrooms.climbing.model.Longueur;
import com.openclassrooms.climbing.model.Reservation;
import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.model.Utilisateur;
import com.openclassrooms.climbing.model.Voie;
import com.openclassrooms.climbing.repository.*;

@Controller // suit le formalisme "rest" c'est un pattern pour faire communiquer des
			// programmes ensembles

public class ClimbingController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private LongueurRepository longueurRepository;

	@GetMapping(value = "/")
	public String home(Model model) {
		Iterable<Utilisateur> users = userRepository.findAll();
		model.addAttribute("users", users);

		Iterable<Commentaire> commentaires = commentaireRepository.findAll();
		model.addAttribute("commentaires", commentaires);

		Iterable<Site> sites = siteRepository.findAll();
		model.addAttribute("sites", sites);

		Iterable<Reservation> reservations = reservationRepository.findAll();
		model.addAttribute("reservations", reservations);

		Iterable<Topo> topos = topoRepository.findAll();
		model.addAttribute("topos", topos);

		Iterable<Secteur> secteurs = secteurRepository.findAll();
		model.addAttribute("secteurs", secteurs);

		Iterable<Voie> voies = voieRepository.findAll();
		model.addAttribute("voies", voies);

		Iterable<Longueur> longueurs = longueurRepository.findAll();
		model.addAttribute("longueurs", longueurs);

		return "home";
	}

	@GetMapping(value = "/aPropos")
	public String aPropos(Model model) {
		return ("aPropos");
	}

	@GetMapping(value = "/deconnexion")
	public String deconnexionProfil(Model model) {
		return ("deconnexion");

	}

	@GetMapping(value="/recherchesites")
	public String rechercheSites(Model model,@RequestParam String searchsites) {
		List<Site> sites = siteRepository.findByNomContaining(searchsites);	
		model.addAttribute("sites", sites);
	return ("rechercheSites");
	}
}
