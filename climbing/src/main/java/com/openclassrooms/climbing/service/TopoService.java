package com.openclassrooms.climbing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.climbing.model.Topo;
import com.openclassrooms.climbing.repository.TopoRepository;

@Service
public class TopoService implements ITopoService {
	@Autowired
	private TopoRepository topoRepository;

	@Override
	public Optional<Topo> findById(Integer id) {
		return topoRepository.findById(id);
	}

}