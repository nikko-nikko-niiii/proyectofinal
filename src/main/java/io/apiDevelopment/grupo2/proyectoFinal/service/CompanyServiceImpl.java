package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.CompanyRequest;
import io.apiDevelopment.grupo2.proyectoFinal.exception.BadRequestException;
import io.apiDevelopment.grupo2.proyectoFinal.exception.UnauthorizedException;
import io.apiDevelopment.grupo2.proyectoFinal.model.Admin;
import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.repository.AdminRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
	private final CompanyRepository companyRepository;
	private final AdminRepository adminRepository;
	
	@Override
	public String createCompany(CompanyRequest companyRequest) {
		
		validateRequest(companyRequest);
		
		Optional<Admin> adminOpt = adminRepository.findByUsername(companyRequest.getUsername());
		
		
		if(adminOpt.isEmpty() || !isPasswordValid(companyRequest.getPassword(), adminOpt.get().getPassword())) {
			throw new UnauthorizedException("Acceso denegado.");
		}
		
		Company company = new Company();
		company.setName(companyRequest.getName());
		company.setApiKey(UUID.randomUUID().toString());
		companyRepository.save(company);
		
		return "Compañia creada, su api key es: " + company.getApiKey();
	}

	private boolean isPasswordValid(String password, String passwordEncrypted) {
		return BCrypt.checkpw(password, passwordEncrypted);
	}
	
	private boolean validateRequest(CompanyRequest companyRequest) {
		if(companyRequest.getName() == null || companyRequest.getName().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo name en el body.");
		}
		
		if(companyRequest.getUsername() == null || companyRequest.getUsername().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo username en el body.");
		}
		
		if(companyRequest.getPassword() == null || companyRequest.getPassword().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo password en el body.");
		}
		
		return true;
	}
}
