package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Location getAllLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getLocationById(String locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location createLocation(Location location) {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Optional<Company> company = companyRepository.findByApiKey(apiKey);
		
		if(company.isEmpty()) {
			throw new RuntimeException("Error compañia no encontrada.");
		}
		
		location.setCompany(company.get());
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(String id, LocationDTO newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLocation(String id) {
		// TODO Auto-generated method stub
		
	}
	
}
