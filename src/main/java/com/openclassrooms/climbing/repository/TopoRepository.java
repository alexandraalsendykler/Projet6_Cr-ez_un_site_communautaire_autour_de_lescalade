package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

}