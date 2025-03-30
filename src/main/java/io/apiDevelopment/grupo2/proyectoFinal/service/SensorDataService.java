package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataRequest;
import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;

public interface SensorDataService {
	List<SensorData> createSensorData(SensorDataRequest sensorData);
	
	List<SensorData> getSensorDataByRangeAndIds(Integer from, Integer to, String sensors);
}
