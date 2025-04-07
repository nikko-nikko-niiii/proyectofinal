package io.apiDevelopment.grupo2.proyectoFinal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequest {
	private String name;
	private String username;
	private String password;
}
