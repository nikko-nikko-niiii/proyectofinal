package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>{
	Optional<Sensor> findByApiKey(String apiKey);
	List<Sensor> findByLocationCompanyApiKey(String companyApiKey);
	Optional<Sensor> findByIdAndLocationCompanyApiKey(Long id, String companyApiKey);
}
