package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataDTO;
import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataRequest;

public interface SensorDataService {
	List<SensorDataDTO> createSensorData(SensorDataRequest sensorDataRequest);
	
	List<SensorDataDTO> getSensorDataByRangeAndIds(Long from, Long to, String sensors);
}
