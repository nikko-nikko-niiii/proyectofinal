package io.apiDevelopment.grupo2.proyectoFinal.model;

import java.util.List;


import io.apiDevelopment.grupo2.proyectoFinal.dto.LocationDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="location")
@NoArgsConstructor
public class Location {

	public Location (LocationDTO locationDTO) {
		this.name = locationDTO.getName();
		this.city = locationDTO.getCity();
		this.country = locationDTO.getCountry();
		this.meta = locationDTO.getMeta();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "location_name")
	private String name;
	@Column(name = "location_country")
	private String country;
	@Column(name = "location_city")
	private String city;
	@Column(name = "location_meta")
	private String meta;

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	private List<Sensor> sensors;
	
}
