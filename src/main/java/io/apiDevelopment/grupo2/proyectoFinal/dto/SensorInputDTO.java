package io.apiDevelopment.grupo2.proyectoFinal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorInputDTO {
	private Long datetime;
	private Double temp;
	private Double humidity;
}
