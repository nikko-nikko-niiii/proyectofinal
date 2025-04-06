package io.apiDevelopment.grupo2.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;
import io.apiDevelopment.grupo2.proyectoFinal.service.LocationService;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/")
	public ResponseEntity<List<LocationDTO>> getLocations(){
		return new ResponseEntity<List<LocationDTO>>(locationService.getAllLocation(), HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id){
		return new ResponseEntity<LocationDTO>(locationService.getLocationById(id), HttpStatus.FOUND);
	}

	@PostMapping("/")
	public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO){
		return new ResponseEntity<LocationDTO>(locationService.createLocation(locationDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LocationDTO> updateLocation(@RequestBody LocationDTO locationDTO, @PathVariable Long id){
		return new ResponseEntity<LocationDTO>(locationService.updateLocation(id, locationDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable Long id){
		return new ResponseEntity<String>(locationService.deleteLocation(id), HttpStatus.OK);
	}
	
}
