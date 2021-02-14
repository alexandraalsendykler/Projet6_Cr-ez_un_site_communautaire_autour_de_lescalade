package com.openclassrooms.climbing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.climbing.model.Commentaire;
import com.openclassrooms.climbing.repository.CommentaireRepository;

@Service
public class CommentaireService implements ICommentaireService {
	@Autowired
	private CommentaireRepository commentaireRepository;

	@Override
	public Optional<Commentaire> findById(Integer id) {
		return commentaireRepository.findById(id);
	}
}