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

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.service.SensorService;

@RestController
@RequestMapping("/api/v1/sensor")
public class SensorController {
	
	@Autowired
	private SensorService sensorService;
	
	@PostMapping("/")
	public ResponseEntity<Sensor> createSensor(@RequestBody SensorDTO sensor){
		return new ResponseEntity<Sensor>(sensorService.createSensor(sensor), HttpStatus.CREATED); 
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Sensor>> getAllSensors(){
		return new ResponseEntity<List<Sensor>>(sensorService.getAllSensors(), HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SensorDTO> getSensorById(@PathVariable Integer id){
		return new ResponseEntity<SensorDTO>(sensorService.getSensorById(id), HttpStatus.OK); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sensor> updateSensor(@PathVariable Integer id, @RequestBody SensorDTO sensor){
		return new ResponseEntity<Sensor>(sensorService.updateSensor(id, sensor), HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSensor(@PathVariable Integer id){
		return new ResponseEntity<String>(sensorService.deleteSensor(id), HttpStatus.OK); 
	}
}
