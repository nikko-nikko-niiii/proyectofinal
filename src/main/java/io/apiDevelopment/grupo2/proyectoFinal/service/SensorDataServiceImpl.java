package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataDTO;
import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDataRequest;
import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorInputDTO;
import io.apiDevelopment.grupo2.proyectoFinal.exception.BadRequestException;
import io.apiDevelopment.grupo2.proyectoFinal.exception.NotFoundException;
import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorDataRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SensorDataServiceImpl implements SensorDataService{
	private final SensorDataRepository sensorDataRepository;
	private final SensorRepository sensorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<SensorDataDTO> createSensorData(SensorDataRequest sensorDataRequest) {
		List<SensorData> sensorDataList = new ArrayList<SensorData>();
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Sensor> sensor = sensorRepository.findByApiKey(apiKey);
		
		if(sensor.isEmpty()) {
			throw new NotFoundException("Sensor no encontrado");
		}
		
		for(SensorInputDTO sensorInputDTO : sensorDataRequest.getJsonData()) {
			validateSensorDataDTO(sensorInputDTO);
			
			SensorData sensorData = new SensorData(sensorInputDTO);
			sensorData.setSensor(sensor.get());
			sensorDataList.add(sensorData);
		}
		
		sensorDataRepository.saveAll(sensorDataList);
		
		return sensorDataList.stream().map((sensorData) -> new SensorDataDTO(sensorData)).toList();
	}

	@Override
	public List<SensorDataDTO> getSensorDataByRangeAndIds(Long from, Long to, String sensorIds) {
		LocalDateTime dateTimeFrom = transformEpochToLocalDateTime(from);
		LocalDateTime dateTimeTo = transformEpochToLocalDateTime(to);
		
		List<Integer> sensorIdList = stringToList(sensorIds);
		
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Company> company = companyRepository.findByApiKey(apiKey);
		
		if(company.isEmpty()) {
			throw new NotFoundException("Compañia no encontrada.");
		}
		
		List<SensorData> sensorDataList = sensorDataRepository.findByDatetimeBetweenAndSensorIdInAndSensorLocationCompanyId(dateTimeFrom, dateTimeTo, sensorIdList, company.get().getId());
		
		if(sensorDataList.isEmpty()){
			throw new NotFoundException("No hay registros del sensor o sensor no esta relacionado a la compañia.");
		}
		
		return sensorDataList.stream().map((sensorData) -> new SensorDataDTO(sensorData)).toList();
	}

	private List<Integer> stringToList(String str){
		List<Integer> list = new ArrayList<Integer>();
		for(String aux : str.split(",")) {
			list.add(Integer.parseInt(aux));
		}
		return list;
	}
	
	private LocalDateTime transformEpochToLocalDateTime(Long epoch) {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.of("America/Santiago"));
	}
	
	private void validateSensorDataDTO(SensorInputDTO sensorInputDTO) {
		if(sensorInputDTO.getDatetime() == null) {
			throw new BadRequestException("Error: Falta el atributo datetime en el body.");
		}
		
		if(sensorInputDTO.getTemp() == null || sensorInputDTO.getTemp().isNaN()) {
			throw new BadRequestException("Error: Falta el atributo temp en el body.");
		}
		
		if(sensorInputDTO.getHumidity() == null || sensorInputDTO.getHumidity().isNaN()) {
			throw new BadRequestException("Error: Falta el atributo humidity en el body.");
		}
	}
}
