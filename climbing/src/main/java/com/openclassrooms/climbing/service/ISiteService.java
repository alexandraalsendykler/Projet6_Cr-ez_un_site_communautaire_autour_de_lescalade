package com.openclassrooms.climbing.service;

import java.util.Optional;

import com.openclassrooms.climbing.model.Site;

public interface ISiteService {
	Optional<Site> findById(Integer id) ;
}
