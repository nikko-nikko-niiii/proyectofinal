package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Company;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.repository.CompanyRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.LocationRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorRepository;

@Service
public class SensorServiceImpl implements SensorService{

	@Autowired
	private SensorRepository sensorRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired 
	private CompanyRepository companyRepository;
	
	@Override
	public Sensor createSensor(SensorDTO sensor) {
		
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Company> company = companyRepository.findByApiKey(apiKey);
		
		Optional<Location> location = locationRepository.findByIdAndCompany(sensor.getIdLocation(), company.get());
		
		Sensor newSensor = new Sensor(null, sensor);
		newSensor.setApiKey(UUID.randomUUID().toString());
		newSensor.setLocation(location.get());
		
		return sensorRepository.save(newSensor);
	}

	@Override
	public List<Sensor> getAllSensors() {
		return sensorRepository.findAll();
	}

	@Override
	public SensorDTO getSensorById(Integer id) {
		Optional<Sensor> sensor =  sensorRepository.findById(id);
		if(sensor.isEmpty()) {
			return null;
		}
		
		return new SensorDTO(sensor.get().getId(), 
				sensor.get().getName(), 
				sensor.get().getCategory(), 
				sensor.get().getMeta(),
				sensor.get().getApiKey(),
				sensor.get().getLocation().getId());
	}

	@Override
	public Sensor updateSensor(Integer id, SensorDTO newSensor) {
		Optional<Sensor> sensor = sensorRepository.findById(id);
		sensor.get().setCategory(newSensor.getCategory());
		sensor.get().setName(newSensor.getName());
		return sensorRepository.save(sensor.get());
	}

	@Override
	public String deleteSensor(Integer id) {
		sensorRepository.deleteById(id);
		return "Sensor "+ id + " eliminado.";
	}

}
