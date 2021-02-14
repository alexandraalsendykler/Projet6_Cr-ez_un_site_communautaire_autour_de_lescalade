package com.openclassrooms.climbing.service;

import java.util.Optional;
import com.openclassrooms.climbing.model.Commentaire;

public interface ICommentaireService {
	Optional<Commentaire> findById(Integer id) ;
}
