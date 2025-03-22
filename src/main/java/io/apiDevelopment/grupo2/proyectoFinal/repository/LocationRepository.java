package io.apiDevelopment.grupo2.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
