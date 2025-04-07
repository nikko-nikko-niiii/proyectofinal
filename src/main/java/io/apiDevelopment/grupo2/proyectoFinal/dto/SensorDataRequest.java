package io.apiDevelopment.grupo2.proyectoFinal.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorDataRequest {
	private List<SensorInputDTO> jsonData;
}
