package io.apiDevelopment.grupo2.proyectoFinal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.dto.CompanyRequest;
import io.apiDevelopment.grupo2.proyectoFinal.service.CompanyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
	private final CompanyService companyService;
	
	@PostMapping("/")
	public ResponseEntity<String> createCompany(@RequestBody CompanyRequest companyDTO) {
		return new ResponseEntity<String>(companyService.createCompany(companyDTO), HttpStatus.CREATED);
	}
	
}
