package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Optional<Admin> findByUsername(String username);
}
