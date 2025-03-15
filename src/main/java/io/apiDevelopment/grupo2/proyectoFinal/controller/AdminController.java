package io.apiDevelopment.grupo2.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;
import io.apiDevelopment.grupo2.proyectoFinal.service.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ResponseEntity<Admin> getAdminByUsername(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.getAdminByUsername(admin), HttpStatus.ACCEPTED);
	}
}
