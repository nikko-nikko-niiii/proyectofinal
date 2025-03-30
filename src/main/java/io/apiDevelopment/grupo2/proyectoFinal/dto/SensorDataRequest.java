package io.apiDevelopment.grupo2.proyectoFinal.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class SensorDataRequest {
	
	private String apiKey;
	private List<SensorDataDTO> jsonData;
	
}
