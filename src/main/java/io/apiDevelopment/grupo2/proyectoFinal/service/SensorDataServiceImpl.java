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
import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorDataRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorRepository;

@Service
public class SensorDataServiceImpl implements SensorDataService{

	@Autowired
	private SensorDataRepository sensorDataRepository;
	@Autowired
	private SensorRepository sensorRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<SensorData> createSensorData(SensorDataRequest SensorDataRequest) {
		
		List<SensorData> sensorDataList = new ArrayList<SensorData>();
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Sensor> sensor = sensorRepository.findByApiKey(apiKey);
		
		if(sensor.isEmpty()) {
			throw new RuntimeException("Sensor no encontrado");
		}
		
		for(SensorDataDTO sensorData : SensorDataRequest.getJsonData()) {
			
			LocalDateTime datetime = transformEpochToLocalDateTime(sensorData.getDatetime());
			SensorData newSensorData = new SensorData(null, 
					datetime, 
					sensorData.getTemp(),
					sensorData.getHumidity(), 
					sensor.get()
			);
			
			sensorDataList.add(newSensorData);
		}
		
		
		return sensorDataRepository.saveAll(sensorDataList);
	}

	@Override
	public List<SensorData> getSensorDataByRangeAndIds(Integer from, Integer to, String sensorIds) {
		LocalDateTime dateTimeFrom = transformEpochToLocalDateTime(from);
		LocalDateTime dateTimeTo = transformEpochToLocalDateTime(to);
		
		List<Integer> sensorIdList = stringToList(sensorIds);
		
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Company> company = companyRepository.findByApiKey(apiKey);
		
		if(company.isEmpty()) {
			throw new RuntimeException("Compañia no encontrada.");
		}
		
		List<SensorData> sensorDataList = sensorDataRepository.findByDatetimeBetweenAndSensorIdInAndSensorLocationCompanyId(dateTimeFrom, dateTimeTo, sensorIdList, company.get().getId());
		
		return sensorDataList;
	}

	private List<Integer> stringToList(String str){
		List<Integer> list = new ArrayList<Integer>();
		for(String aux : str.split(",")) {
			list.add(Integer.parseInt(aux));
		}
		return list;
	}
	
	private LocalDateTime transformEpochToLocalDateTime(Integer epoch) {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());

	}
	
}
