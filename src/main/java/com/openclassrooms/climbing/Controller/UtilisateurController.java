package com.openclassrooms.climbing.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.climbing.model.Utilisateur;
import com.openclassrooms.climbing.repository.UserRepository;

@Controller
public class UtilisateurController<User> {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/profil")
	public String profilUtilisateur(Model model) {
		return "profilUtilisateur";

	}

	@GetMapping(value = "/inscription")
	public String inscription(Model model) {
		model.addAttribute("users", new Utilisateur());
		return "inscription";
	}

	@GetMapping(value = "/connexion")
	public String seConnecter(Model model) {
		return "seConnecter";
	}
	
	@PostMapping("/saveinscription")
	public ModelAndView saveInscription(@ModelAttribute Utilisateur users, Model model) {
		String password = users.getMotdepasse();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		users.setMotdepasse(encoder.encode(password));
		
		List<Utilisateur> utilisateur = Arrays.asList(users);
		userRepository.saveAll(utilisateur);
			
		return new ModelAndView("redirect:/connexion");
	}
	
}
