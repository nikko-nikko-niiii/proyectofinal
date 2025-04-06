package io.apiDevelopment.grupo2.proyectoFinal.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SensorDataRequest {
	private List<SensorInputDTO> jsonData;
}
