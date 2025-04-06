package io.apiDevelopment.grupo2.proyectoFinal.dto;

import io.apiDevelopment.grupo2.proyectoFinal.model.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {
	
	public LocationDTO(Location location) {
		this.name = location.getName();
		this.city = location.getCity();
		this.country = location.getCountry();
		this.meta = location.getMeta();
		this.companyName = location.getCompany().getName();
	}
	
	private String name;
	private String country;
	private String city;
	private String meta;
	private String companyName;
}
