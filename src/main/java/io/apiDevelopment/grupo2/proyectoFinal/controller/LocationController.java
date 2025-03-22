package io.apiDevelopment.grupo2.proyectoFinal.controller;

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

import io.apiDevelopment.grupo2.proyectoFinal.controller.dto.LocationDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;
import io.apiDevelopment.grupo2.proyectoFinal.service.LocationService;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/")
	public ResponseEntity<Location> getLocations(){
		return new ResponseEntity<Location>(locationService.getAllLocation(), HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable String id){
		return new ResponseEntity<Location>(locationService.getLocationById(id), HttpStatus.FOUND);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Location> createLocation(@RequestBody LocationDTO location){
		return new ResponseEntity<Location>(locationService.createLocation(location), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Location> updateLocation(@RequestBody LocationDTO location, @PathVariable String id){
		return new ResponseEntity<Location>(locationService.updateLocation(id,location), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable String id){
		locationService.deleteLocation(id);
	}
	
}
