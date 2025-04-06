package io.apiDevelopment.grupo2.proyectoFinal.model;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import jakarta.persistence.Column;
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

@Getter
@Setter
@Entity
@Table(name = "sensor")
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
	
	public Sensor(SensorDTO sensorDTO) {
		this.name = sensorDTO.getName();
		this.category = sensorDTO.getCategory();
		this.meta = sensorDTO.getMeta();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sensor_name")
	private String name;
	
	@Column(name = "sensor_category")
	private String category;
	
	@Column(name = "sensor_meta")
	private String meta;
	
	@Column(name = "sensor_api_key")
	private String apiKey;
	
	@ManyToOne
	@JoinColumn(name = "id_location")
	private Location location;
	
}
