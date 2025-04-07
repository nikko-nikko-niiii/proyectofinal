package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;

public interface LocationService {
	List<LocationDTO> getAllLocation();
	LocationDTO getLocationById(Long id);
	LocationDTO createLocation(LocationDTO locationDTO);
	LocationDTO updateLocation(Long id, LocationDTO locationDTO);
	String deleteLocation(Long id);
}
