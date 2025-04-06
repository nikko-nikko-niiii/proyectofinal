package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;

public interface SensorService {
	String createSensor(SensorDTO sensorDTO);
	List<SensorDTO> getAllSensors();
	SensorDTO getSensorById(Long id);
	SensorDTO updateSensor(Long id, SensorDTO newSensorDTO);
	String deleteSensor(Long id);
}
