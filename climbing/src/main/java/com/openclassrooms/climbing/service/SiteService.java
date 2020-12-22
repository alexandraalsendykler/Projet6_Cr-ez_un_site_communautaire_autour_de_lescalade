package com.openclassrooms.climbing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.climbing.model.Site;
import com.openclassrooms.climbing.repository.SiteRepository;

@Service
public class SiteService implements ISiteService {
	@Autowired
	private SiteRepository siteRepository;
	

    @Override
    public Optional<Site> findById(Integer id) {
    	return siteRepository.findById(id);
    }
	
}
