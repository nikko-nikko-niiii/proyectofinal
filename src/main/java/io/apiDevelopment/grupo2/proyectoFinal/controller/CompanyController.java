package io.apiDevelopment.grupo2.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.service.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/create")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.createCompany(company), HttpStatus.CREATED);
	}
}
