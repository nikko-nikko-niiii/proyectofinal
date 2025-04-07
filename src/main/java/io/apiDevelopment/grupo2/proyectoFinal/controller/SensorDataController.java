package io.apiDevelopment.grupo2.proyectoFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataDTO;
import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataRequest;
import io.apiDevelopment.grupo2.proyectoFinal.service.SensorDataService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/sensor_data")
@RequiredArgsConstructor
public class SensorDataController {
	private final SensorDataService sensorDataService;
	
	@PostMapping("/")
	public ResponseEntity<List<SensorDataDTO>> createSensorData(@RequestBody SensorDataRequest sensorDataRequest) {
		return new ResponseEntity<List<SensorDataDTO>>(sensorDataService.createSensorData(sensorDataRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<SensorDataDTO>> getSensorDataByRangeAndIds(@RequestParam Long from, @RequestParam Long to, @RequestParam(value = "sensor_id") String sensorIds){
		return new ResponseEntity<List<SensorDataDTO>>(sensorDataService.getSensorDataByRangeAndIds(from, to, sensorIds), HttpStatus.FOUND);
	}
}
