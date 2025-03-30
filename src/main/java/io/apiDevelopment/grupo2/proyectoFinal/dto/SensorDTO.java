package io.apiDevelopment.grupo2.proyectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SensorDTO {
	private Integer id;
	
	private String name;
	
	private String category;
	
	private String meta;
	
	private String apiKey;
	
	private Integer idLocation;
}
