package io.apiDevelopment.grupo2.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer>{

}
