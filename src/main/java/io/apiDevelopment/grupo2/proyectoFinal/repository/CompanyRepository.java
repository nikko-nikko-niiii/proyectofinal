package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	Optional<Company> findByApiKey(String apiKey); 
}
