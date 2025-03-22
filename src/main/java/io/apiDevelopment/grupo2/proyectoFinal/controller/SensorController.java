package io.apiDevelopment.grupo2.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.service.SensorService;

@RestController
@RequestMapping("/api/v1/sensor")
public class SensorController {
	
	@Autowired
	private SensorService sensorService;
	
	@PostMapping("/")
	public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor){
		return new ResponseEntity<Sensor>(sensorService.createSensor(sensor), HttpStatus.CREATED); 
		
		//prueba
	}

}
