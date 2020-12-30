package com.openclassrooms.climbing.service;

import java.util.Optional;

import com.openclassrooms.climbing.model.Topo;

public interface ITopoService {



	Optional<Topo> findById(Integer id);
}
