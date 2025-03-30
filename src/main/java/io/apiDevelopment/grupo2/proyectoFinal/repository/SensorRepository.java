package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer>{
	Optional<Sensor> findByApiKey(String apiKey);
}
