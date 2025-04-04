package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company createCompany(Company company) {
		
		company.setApiKey(UUID.randomUUID().toString());
		
		return companyRepository.save(company);
	}

}
