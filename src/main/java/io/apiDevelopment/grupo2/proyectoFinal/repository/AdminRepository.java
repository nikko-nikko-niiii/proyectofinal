package io.apiDevelopment.grupo2.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
}
