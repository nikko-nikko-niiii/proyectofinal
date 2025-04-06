package io.apiDevelopment.grupo2.proyectoFinal.dto;

import java.time.LocalDateTime;

import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorDataDTO {
	public SensorDataDTO(SensorData sensorData) {
		this.datetime = sensorData.getDatetime();
		this.temp = sensorData.getTemp();
		this.humidity = sensorData.getHumidity();
		this.sensorName = sensorData.getSensor().getName();
	}
	
	private LocalDateTime datetime;
	private Double temp;
	private Double humidity;
	private String sensorName;
}
