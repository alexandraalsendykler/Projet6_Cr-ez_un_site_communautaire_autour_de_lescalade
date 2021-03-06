package com.openclassrooms.climbing.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.climbing.model.Reservation;
import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.model.Utilisateur;
import com.openclassrooms.climbing.repository.ReservationRepository;
import com.openclassrooms.climbing.repository.SiteRepository;
import com.openclassrooms.climbing.repository.TopoRepository;
import com.openclassrooms.climbing.repository.UserRepository;

@Controller
@SessionAttributes
public class UtilisateurController<User> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping(value = "/profil")
	public String profilUtilisateur(Model model, HttpSession session) {
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("user");
		model.addAttribute("connectedUser", connectedUser);
		System.out.println(connectedUser.getPseudo());
		Iterable<Topo> topos = topoRepository.findByUtilisateur(connectedUser);
		Iterable<Reservation> reservations = reservationRepository.findByUtilisateur(connectedUser);
		model.addAttribute("reservations", reservations);
		model.addAttribute("topos", topos);
		model.addAttribute("newTopo", new Topo());
		Iterable<Site> site = siteRepository.findAll();
		model.addAttribute("sitesAll", site);
		return "profilUtilisateur";
	}

	@GetMapping(value = "/inscription")
	public String inscription(Model model) {
		model.addAttribute("users", new Utilisateur());
		return "inscription";
	}

	@GetMapping(value = "/connexion")
	public String seConnecter(Model model) {
		model.addAttribute("users", new Utilisateur());

		return "seConnecter";
	}

	@PostMapping("/saveinscription")
	public ModelAndView saveInscription(@ModelAttribute Utilisateur user, Model model) {
		String password = user.getMotdepasse();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setMotdepasse(encoder.encode(password));
		user.setMembre(false);
		userRepository.save(user);

		return new ModelAndView("redirect:/connexion");
	}

	@PostMapping("/seConnecter")
	public ModelAndView seConnecter(@ModelAttribute Utilisateur users, ModelMap model, HttpSession session) {
		String email = users.getEmail();
		String password = users.getMotdepasse();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		List<Utilisateur> utilisateurs = userRepository.findByEmail(email);
		for (Utilisateur utilisateur : utilisateurs) {
			boolean isPasswordMatch = encoder.matches(password, utilisateur.getMotdepasse());
			if (isPasswordMatch == true) {
				session.setAttribute("user", utilisateur);
				return new ModelAndView("redirect:/profil");

			} else {
				model.addAttribute("seConnecterErreur", true);
			}
		}
		return new ModelAndView("redirect:/connexion", model);
	}

	@GetMapping(value = "/deconnexion")
	public String deconnexionProfil(Model model, HttpSession session) {
		session.invalidate();
		return ("deconnexion");

	}
	
	
	@PostMapping(value = "/savetopo")
	public ModelAndView profilUtilisateur(@ModelAttribute Topo newTopo, Model model, HttpSession session) {
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("user");
		newTopo.setUtilisateur(connectedUser);
		topoRepository.save(newTopo);	
	
		return new ModelAndView("redirect:/profil");

	} 

}
