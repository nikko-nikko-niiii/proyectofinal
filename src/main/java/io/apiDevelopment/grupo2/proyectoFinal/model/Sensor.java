package io.apiDevelopment.grupo2.proyectoFinal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sensor_name")
	private String name;
	
	@Column(name = "sensor_category")
	private String category;
	
	@Column(name = "sensor_meta")
	private String meta;
	
	@Column(name = "sensor_api_key")
	private String apiKey;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "id_location")
	//private Integer id_location; --Falta la clase

}
