package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
	Optional<Location> findByIdAndCompanyApiKey(Long id, String apiKey); 
	Optional<Location> findByNameAndCompanyApiKey(String name, String apiKey); 
	List<Location> findByCompanyApiKey(String apiKey);
	
}
