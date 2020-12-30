package com.openclassrooms.climbing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.repository.SecteurRepository;
import com.openclassrooms.climbing.repository.SiteRepository;
import com.openclassrooms.climbing.repository.TopoRepository;
import com.openclassrooms.climbing.service.ISiteService;

@Controller 
public class SiteController {

	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private ISiteService siteService;

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SecteurRepository secteurRepository;

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

		return ("site");
	}

}
