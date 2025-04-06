package io.apiDevelopment.grupo2.proyectoFinal.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sensor_data")
public class SensorData {
	
	public SensorData(SensorInputDTO SensorInputDTO) {
		this.datetime = LocalDateTime.ofInstant(Instant.ofEpochSecond(SensorInputDTO.getDatetime()), ZoneId.of("America/Santiago"));
		this.temp = SensorInputDTO.getTemp();
		this.humidity = SensorInputDTO.getHumidity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime datetime;
	
	private Double temp;
	
	private Double humidity;
	
	@ManyToOne
	@JoinColumn(name = "id_sensor")
	private Sensor sensor;
}
