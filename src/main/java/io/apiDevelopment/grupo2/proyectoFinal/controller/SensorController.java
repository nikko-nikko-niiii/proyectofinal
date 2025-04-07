package io.apiDevelopment.grupo2.proyectoFinal.controller;

import java.util.List;

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

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.service.SensorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/sensor")
@RequiredArgsConstructor
public class SensorController {
	private final SensorService sensorService;
	
	@PostMapping("/")
	public ResponseEntity<String> createSensor(@RequestBody SensorDTO sensor){
		return new ResponseEntity<String>(sensorService.createSensor(sensor), HttpStatus.CREATED); 
	}
	
	@GetMapping("/")
	public ResponseEntity<List<SensorDTO>> getAllSensors(){
		return new ResponseEntity<List<SensorDTO>>(sensorService.getAllSensors(), HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SensorDTO> getSensorById(@PathVariable Long id){
		return new ResponseEntity<SensorDTO>(sensorService.getSensorById(id), HttpStatus.OK); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SensorDTO> updateSensor(@PathVariable Long id, @RequestBody SensorDTO sensor){
		return new ResponseEntity<SensorDTO>(sensorService.updateSensor(id, sensor), HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSensor(@PathVariable Long id){
		return new ResponseEntity<String>(sensorService.deleteSensor(id), HttpStatus.OK); 
	}
}
