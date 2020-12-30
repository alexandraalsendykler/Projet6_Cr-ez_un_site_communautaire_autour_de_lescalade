package com.openclassrooms.climbing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.repository.TopoRepository;

@Controller

public class TopoController {
	
	@Autowired
	private TopoRepository topoRepository;
	
	@GetMapping(value="touslestopos")
	public String touslestopos(Model model) {
		Iterable<Topo> topo = topoRepository.findAll();
		model.addAttribute("topos", topo);
		return("touslestopos");
	}

}
