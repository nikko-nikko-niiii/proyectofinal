package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	Optional<Location> findByIdAndCompany(Integer id, Company company); 
}
