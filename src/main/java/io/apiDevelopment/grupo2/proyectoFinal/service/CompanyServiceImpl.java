package io.apiDevelopment.grupo2.proyectoFinal.service;

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
		
		//TODO: Validar sesión con token JWT de Admin
		// if()
		// throw Unauthorized
		if(company.getName() == null) {
			// throw BadRequest
			return null;
		}
		
		return companyRepository.save(company);
	}

	@Override
	public Company getCompanyById(Integer id) {
		return companyRepository.findById(id).get();
	}

}
