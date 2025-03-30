package io.apiDevelopment.grupo2.proyectoFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;
import io.apiDevelopment.grupo2.proyectoFinal.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	public AdminServiceImpl adminService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin){
		return null;
	}
	
	@GetMapping("/user")
    public String user() {
        return "Hola";
    }
}
