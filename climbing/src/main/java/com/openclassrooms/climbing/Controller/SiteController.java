package com.openclassrooms.climbing.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.climbing.model.Commentaire;
import com.openclassrooms.climbing.model.Longueur;
import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.model.Utilisateur;
import com.openclassrooms.climbing.model.Voie;
import com.openclassrooms.climbing.repository.SecteurRepository;
import com.openclassrooms.climbing.repository.SiteRepository;
import com.openclassrooms.climbing.repository.TopoRepository;
import com.openclassrooms.climbing.repository.VoieRepository;
import com.openclassrooms.climbing.service.ISiteService;
import com.openclassrooms.climbing.repository.CommentaireRepository;
import com.openclassrooms.climbing.repository.LongueurRepository;

@Controller
@SessionAttributes
public class SiteController {

	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private ISiteService siteService;

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private LongueurRepository longueurRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@GetMapping(value = "/recherchesites")
	public String rechercheSites(Model model, @RequestParam String searchsites,
			@RequestParam(required = false) Boolean officiel) {
		if (officiel != null) {
			List<Site> sites = siteRepository.findByNomContainingAndOfficiel(searchsites, officiel);
			model.addAttribute("sites", sites);
		} else {

			List<Site> sites = siteRepository.findByNomContaining(searchsites);
			model.addAttribute("sites", sites);
		}

		return ("rechercheSites");
	}

	@GetMapping(value = "/sitesescalades")
	public String sitesescaldes(Model model) {
		Iterable<Site> site = siteRepository.findAll();
		model.addAttribute("sites", site);
		return ("sitesescalades");
	}

	@RequestMapping(path = "/site/{id}")
	public String site(Model model, @PathVariable("id") Integer id) {
		Optional<Site> site = siteService.findById(id);
		model.addAttribute("sites", site.get());
		List<Topo> topo = topoRepository.findAllBySites(site.get());
		model.addAttribute("topos", topo);
		List<Secteur> secteur = secteurRepository.findBySites(site.get());
		model.addAttribute("secteurs", secteur);
		model.addAttribute("commentaire", new Commentaire());

		return ("site");
	}

	@PostMapping("/savecommentaire/{id}")
	public ModelAndView saveCommentaire(@ModelAttribute Commentaire commentaire, Model model,
			@PathVariable("id") Integer id, HttpSession session) {
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		commentaire.setUtilisateur(utilisateur);
		Optional<Site> site = siteService.findById(id);
		commentaire.setSite(site.get());
		commentaireRepository.save(commentaire);
		return new ModelAndView("redirect:/site/{id}");

	}

	@GetMapping("/ajouternouveausite")
	public String ajouternouveausite(Model model) {
		model.addAttribute("site", new Site());
		return ("ajouternouveausite");
	}

	@PostMapping("/ajouternouveausecteur")
	public String ajouternouveausecteur(@ModelAttribute Site site, Model model, HttpSession session) {
		site.setOfficiel(false);
		siteRepository.save(site);
		session.setAttribute("site", site);
		model.addAttribute("secteur", new Secteur());
		return ("/ajouternouveausecteur");
	}



	@PostMapping("/ajouternouvellevoie")
	public String ajouternouvellevoie(@ModelAttribute Secteur secteur, Model model, HttpSession session) {
		Site site = (Site) session.getAttribute("site");
		secteur.setSite(site);
		secteurRepository.save(secteur);
		session.setAttribute("secteur", secteur);
		model.addAttribute("voie", new Voie());
		return ("ajouternouvellevoie");
	}


	
	@PostMapping("/ajouternouvellelongueur")
	public String ajouternouvellelongueur(@ModelAttribute Voie voie, Model model, HttpSession session) {
		Secteur secteur = (Secteur) session.getAttribute("secteur");
		voie.setSecteurs(secteur);
		voieRepository.save(voie);
		session.setAttribute("voie", voie);
		model.addAttribute("longueur", new Longueur());
		return("ajouternouvellelongueur");
	}
	

	
	@PostMapping("/confirmationajout")
	public String confirmationajout(@ModelAttribute Longueur longueur, Model model, HttpSession session) {
		Voie voie = (Voie) session.getAttribute("voie");
		longueur.setVoie(voie);
		longueurRepository.save(longueur);
		session.removeAttribute("voie");
		session.removeAttribute("site");
		session.removeAttribute("secteur");
		return("confirmationajout");
		
	}
}
