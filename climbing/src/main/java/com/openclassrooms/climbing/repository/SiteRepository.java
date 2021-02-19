package com.openclassrooms.climbing.repository;

import com.openclassrooms.climbing.model.Site;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

	List <Site> findByNomContaining(String nom);
	List<Site> findByNomContainingOrAndOfficiel(String nom, Boolean officiel);
	@Query("select s from Site s left join s.topos t where lower(t.region) like	lower('%' || :region || '%') OR lower(s.nom) like 	lower('%' || :nom || '%')  ")
	List<Site> findByRegionContainingOrNomContaining(@Param("region")  String region,@Param("nom")  String nom);
	@Query("select s from Site s left join s.topos t where (lower(t.region ) like 	lower('%' || :region || '%') OR lower(s.nom) like 	lower('%' || :nom || '%')   ) AND s.officiel = :officiel")
	List<Site> findByRegionContainingOrNomContainingAndOfficiel(@Param("region")  String region,@Param("nom")  String nom, Boolean officiel);
}
