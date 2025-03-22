package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;

public interface SensorService {
	Sensor createSensor(SensorDTO sensor);
	List<Sensor> getAllSensors();
	SensorDTO getSensorById(Integer id);
	Sensor updateSensor(Integer id, SensorDTO newSensor);
	String deleteSensor(Integer id);
}
