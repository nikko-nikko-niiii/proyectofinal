package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;

public interface LocationService {
	List<LocationDTO> getAllLocation();
	LocationDTO getLocationById(Long locationId);
	LocationDTO createLocation(LocationDTO locationDTO);
	LocationDTO updateLocation(Long id, LocationDTO newLocationDTO);
	String deleteLocation(Long id);
}
