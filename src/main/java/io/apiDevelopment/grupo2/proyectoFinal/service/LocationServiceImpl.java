package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;
import io.apiDevelopment.grupo2.proyectoFinal.exception.BadRequestException;
import io.apiDevelopment.grupo2.proyectoFinal.exception.NotFoundException;
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
	public List<LocationDTO> getAllLocation() {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		List<Location> locations = locationRepository.findByCompanyApiKey(apiKey); 

		return locations.stream().map((location) -> new LocationDTO(location)).toList();
	}

	@Override
	public LocationDTO getLocationById(Long id) {
		Location location = getValidatedLocation(id);
		return new LocationDTO(location);
	}

	@Override
	public LocationDTO createLocation(LocationDTO locationDTO) {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Optional<Company> company = companyRepository.findByApiKey(apiKey);
		
		if(company.isEmpty()) {
			throw new NotFoundException("Error compañia no encontrada.");
		}

		validateLocationDTO(locationDTO);
			
		Location location = new Location(locationDTO);
		
		location.setCompany(company.get());
		locationRepository.save(location);
		
		locationDTO.setCompanyName(company.get().getName());
		
		return locationDTO;
	}
	
	@Override
	public LocationDTO updateLocation(Long id, LocationDTO newLocationDTO) {
		
		validateLocationDTO(newLocationDTO);
		
		Location location = getValidatedLocation(id);
		
		location.setName(newLocationDTO.getName());
		location.setCity(newLocationDTO.getCity());
		location.setCountry(newLocationDTO.getCountry());
		location.setMeta(newLocationDTO.getMeta());

		locationRepository.save(location);
		
		return new LocationDTO(location);
	}

	@Override
	public String deleteLocation(Long id) {
		getValidatedLocation(id);
		
		locationRepository.deleteById(id);			

		return "Location con id: " + id + " fue eliminado correctamente.";
	}
	
	private Location getValidatedLocation(Long id) {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Location> locationOpt = locationRepository.findByIdAndCompanyApiKey(id, apiKey);
		
		if(locationOpt.isEmpty()) {
			throw new NotFoundException("No existe la localización con ese id o no esta asociado a la compañia.");
		}
		
		return locationOpt.get();
	}
	
	private void validateLocationDTO(LocationDTO locationDTO) {
		
		if(locationDTO.getName() == null || locationDTO.getName().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo name en el body.");
		}
		
		if(locationDTO.getCity() == null || locationDTO.getCity().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo city en el body.");
		}
		
		if(locationDTO.getCountry() == null || locationDTO.getCountry().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo country en el body.");
		}
		
		if(locationDTO.getMeta() == null || locationDTO.getMeta().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo meta en el body.");
		}

	}
}
