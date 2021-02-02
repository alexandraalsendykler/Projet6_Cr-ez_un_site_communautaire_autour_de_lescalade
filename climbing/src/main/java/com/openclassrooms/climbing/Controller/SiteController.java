package com.openclassrooms.climbing.Controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("/savesite") 
	public String savesSite(@ModelAttribute Site sites, Model model) {

		
		 int id = sites.getId();
		 Optional<Site> site = siteService.findById(id);
		 Site updateSite = site.get();
		 updateSite.setOfficiel(sites.getOfficiel());
		 siteRepository.save(updateSite);
	//	return new ModelAndView("redirect:/sitesescalades");
		 return "redirect:/site/"+String.valueOf(id); //ne convertit pas de string
		// vers int
	}
	// créé une autre méthode par exemple updateofficielstatus qui va récupérer en entrer une valeur string
	// case à cocher et lui transmettre l'id aussi // get l'objet entier, & modifier le statut et save l'objet dans site.repository

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
		return "ajouternouveausite";
	}

	@PostMapping("/ajouternouveausecteur")
	public String ajouternouveausecteur(@ModelAttribute Site site, Model model, HttpSession session) {

		site.setOfficiel(false);
		// siteRepository.save(site);
		session.setAttribute("site", site);
		model.addAttribute("secteur", new Secteur());
		return ("/ajouternouveausecteur");
	}

	@PostMapping("/ajouternouvellevoie")
	public String ajouternouvellevoie(@RequestParam(required = false, value = "next") String next,
			@RequestParam(required = false, value = "addSecteur") String addSecteur, @ModelAttribute Secteur secteur,
			Model model, HttpSession session) {
		String redirect = "";

		List<Secteur> secteurs = (List<Secteur>) session.getAttribute("secteurs");
		List<Secteur> newsecteurs = new ArrayList<Secteur>();
		if (secteurs != null) {

			newsecteurs = secteurs;
		}

		Site site = (Site) session.getAttribute("site");
		site.getSecteurs().add(secteur); // on ajoute les secteur à la liste des secteurs du site
		secteur.setSite(site);
		newsecteurs.add(secteur);

		session.setAttribute("secteur", secteur);
		session.setAttribute("secteurs", newsecteurs);
		if (addSecteur != null) {
			model.addAttribute("secteur", new Secteur());
			redirect = "ajouternouveausecteur";
		} else if (next != null) {
			model.addAttribute("voie", new Voie());
			redirect = "ajouternouvellevoie";
		}
		return redirect;
	}

	@PostMapping("/ajouternouvellelongueur")
	public String ajouternouvellelongueur(@RequestParam(required = false, value = "next") String next,
			@RequestParam(required = false, value = "finish") String finish,
			@RequestParam(required = false, value = "addVoie") String addVoie,
			@RequestParam(required = false, value = "addSecteur") String addSecteur, @ModelAttribute Voie voie,
			Model model, HttpSession session, RedirectAttributes redirectattributes) {

		String redirect = "";

		List<Voie> voies = (List<Voie>) session.getAttribute("voies");
		List<Voie> newvoies = new ArrayList<Voie>();
		if (voies != null) {
			newvoies = voies;
		}
		Secteur secteur = (Secteur) session.getAttribute("secteur");
		voie.setSecteurs(secteur); // voir ligne site.getSecteurs().add(secteur) soit la ligne 149
		session.setAttribute("voie", voie);
		newvoies.add(voie);
		session.setAttribute("voies", newvoies);
		if (addVoie != null) {
			model.addAttribute("voie", new Voie());
			redirect = "ajouternouvellevoie";
		} else if (addSecteur != null) {
			model.addAttribute("secteur", new Secteur());
			redirect = "ajouternouveausecteur";
		} else if (next != null) {
			model.addAttribute("longueur", new Longueur());
			redirect = "ajouternouvellelongueur";
		} else if (finish != null) {
			redirectattributes.addAttribute("finish", true);
			Site site = (Site) session.getAttribute("site");
			siteRepository.save(site);
			List<Secteur> secteurs = (List<Secteur>) session.getAttribute("secteurs");
			secteurRepository.saveAll(secteurs);
			voieRepository.saveAll(newvoies);
			List<Longueur> longueurs = (List<Longueur>) session.getAttribute("longueurs");
			if (longueurs != null) {
				longueurRepository.saveAll(longueurs);
			}
			
			redirect = "confirmationajout";
			return  redirect;
		}


		return redirect;
	}

	@PostMapping("/confirmationajout")
	public String confirmationajout(@RequestParam(required = false, value = "next") String next,
			@RequestParam(required = false, value = "addLongueur") String addLongueur,
			@RequestParam(required = false, value = "addVoie") String addVoie,
			@RequestParam(required = false, value = "addSecteur") String addSecteur, @ModelAttribute Longueur longueur,
			Model model, HttpSession session) {
		String redirect = "";
		System.out.println("ratt " + next);
		List<Longueur> longueurs = (List<Longueur>) session.getAttribute("longueurs");
		List<Longueur> newlongueurs = new ArrayList<Longueur>();
		if (longueurs != null) {
			newlongueurs = longueurs;
		}

		if (longueur != null) {
			Voie voie = (Voie) session.getAttribute("voie");
			longueur.setVoie(voie);
			newlongueurs.add(longueur);
			session.setAttribute("longueurs", newlongueurs);
		}

		if (addLongueur != null) {
			model.addAttribute("longueur", new Longueur());
			redirect = "ajouternouvellelongueur";
		} else if (addVoie != null) {
			model.addAttribute("voie", new Voie());
			redirect = "ajouternouvellevoie";
		} else if (addSecteur != null) {
			model.addAttribute("secteur", new Secteur());
			redirect = "ajouternouveausecteur";
		} else if (next != null) {
			Site site = (Site) session.getAttribute("site");
			siteRepository.save(site);
			List<Secteur> secteurs = (List<Secteur>) session.getAttribute("secteurs");
			secteurRepository.saveAll(secteurs);
			List<Voie> voies = (List<Voie>) session.getAttribute("voies");
			voieRepository.saveAll(voies);

			longueurRepository.saveAll(newlongueurs);

			session.removeAttribute("voie");
			session.removeAttribute("site");
			session.removeAttribute("secteur");
			redirect = "confirmationajout";
		}

		return redirect;

	}
}
