package io.apiDevelopment.grupo2.proyectoFinal.dto;

import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SensorDTO {
	
	public SensorDTO (Sensor sensor) {
		this.name = sensor.getName();
		this.category = sensor.getCategory();
		this.meta = sensor.getMeta();
		this.locationName = sensor.getLocation().getName();
	}
	
	private String name;
	
	private String category;
	
	private String meta;
	
	private String locationName;
}
