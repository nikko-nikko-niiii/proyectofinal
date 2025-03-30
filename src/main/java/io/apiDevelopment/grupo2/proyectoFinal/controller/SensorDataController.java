package io.apiDevelopment.grupo2.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataRequest;
import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;
import io.apiDevelopment.grupo2.proyectoFinal.service.SensorDataService;

@RestController
@RequestMapping("/api/v1/sensor_data")
public class SensorDataController {
	
	@Autowired
	private SensorDataService sensorDataService;
	
	@PostMapping("/")
	public ResponseEntity<List<SensorData>> createSensorData(@RequestBody SensorDataRequest sensorData) {
		return new ResponseEntity<List<SensorData>>(sensorDataService.createSensorData(sensorData), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<SensorData>> getSensorDataByRangeAndIds(@RequestParam Integer from, @RequestParam Integer to, @RequestParam(value = "sensor_id") String sensorIds){
		return new ResponseEntity<List<SensorData>>(sensorDataService.getSensorDataByRangeAndIds(from, to, sensorIds), HttpStatus.FOUND);
	}
}
