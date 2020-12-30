package com.openclassrooms.climbing.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.climbing.model.Secteur;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.repository.TopoRepository;
import com.openclassrooms.climbing.service.ISiteService;
import com.openclassrooms.climbing.service.ITopoService;

@Controller

public class TopoController {

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private ITopoService topoService;

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

}
