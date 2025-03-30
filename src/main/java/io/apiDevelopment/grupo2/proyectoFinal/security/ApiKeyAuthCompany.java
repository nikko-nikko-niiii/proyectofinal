package io.apiDevelopment.grupo2.proyectoFinal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class ApiKeyAuthCompany {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Optional<Authentication> extract(HttpServletRequest request){
		String providedKey = request.getHeader("API-KEY");
		
		Optional<Company> apiKey = companyRepository.findByApiKey(providedKey);
		
		if(apiKey.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(new ApiKeyAuthToken(apiKey.get().getApiKey(), AuthorityUtils.NO_AUTHORITIES));
	}
}
