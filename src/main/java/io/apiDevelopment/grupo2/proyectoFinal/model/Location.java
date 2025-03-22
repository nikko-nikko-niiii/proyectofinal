package io.apiDevelopment.grupo2.proyectoFinal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "location_name")
	private String name;
	@Column(name = "location_country")
	private String country;
	@Column(name = "location_city")
	private String city;
	@Column(name = "location_meta")
	private String meta;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_company")
	private String id_company;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Company company;
	
}
