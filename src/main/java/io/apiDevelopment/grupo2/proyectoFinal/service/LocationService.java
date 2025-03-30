package io.apiDevelopment.grupo2.proyectoFinal.service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;


public interface LocationService {
	Location getAllLocation();
	Location getLocationById(String locationId);
	Location createLocation(Location location);
	Location updateLocation(String id, LocationDTO newLocation);
	void deleteLocation(String id);
}
