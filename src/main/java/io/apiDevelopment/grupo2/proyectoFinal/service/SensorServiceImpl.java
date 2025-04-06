package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.exception.BadRequestException;
import io.apiDevelopment.grupo2.proyectoFinal.exception.NotFoundException;
import io.apiDevelopment.grupo2.proyectoFinal.model.Location;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.repository.LocationRepository;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorRepository;

@Service
public class SensorServiceImpl implements SensorService{

	@Autowired
	private SensorRepository sensorRepository;
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public String createSensor(SensorDTO sensorDTO) {
		
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

		Optional<Location> location = locationRepository.findByNameAndCompanyApiKey(sensorDTO.getLocationName(), apiKey);
		
		if(location.isEmpty()) {
			throw new NotFoundException("Localización no encontrada.");
		}
		
		validateSensorDTO(sensorDTO);
		
		Sensor sensor = new Sensor(sensorDTO);
		sensor.setApiKey(UUID.randomUUID().toString());
		sensor.setLocation(location.get());
		
		sensorRepository.save(sensor);
		
		return "Sensor creado correctamente, la api key es: " + sensor.getApiKey();
	}


	@Override
	public List<SensorDTO> getAllSensors() {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		List<Sensor> sensors = sensorRepository.findByLocationCompanyApiKey(apiKey);
	
		return sensors.stream().map((sensor) -> new SensorDTO(sensor)).toList();
	}

	@Override
	public SensorDTO getSensorById(Long id) {
		Sensor sensor = getValidatedSensor(id);
		return new SensorDTO(sensor);
	}

	@Override
	public SensorDTO updateSensor(Long id, SensorDTO sensorDTO) {
		validateSensorDTO(sensorDTO);
		
		Sensor sensor = getValidatedSensor(id);
		
		sensor.setCategory(sensorDTO.getCategory());
		sensor.setName(sensorDTO.getName());
		sensor.setMeta(sensorDTO.getMeta());
		
		sensorRepository.save(sensor);
		
		return new SensorDTO(sensor);
	}

	@Override
	public String deleteSensor(Long id) {
		getValidatedSensor(id);
		
		sensorRepository.deleteById(id);
		
		return "Sensor "+ id + " eliminado.";
	}
	
	private Sensor getValidatedSensor(Long id) {
		String apiKey = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		
		Optional<Sensor> sensorOpt = sensorRepository.findByIdAndLocationCompanyApiKey(id, apiKey);
		
		if(sensorOpt.isEmpty()) {
			throw new NotFoundException("No existe la localización con ese id o no esta asociado a la compañia.");
		}
		
		return sensorOpt.get();
	}

	private void validateSensorDTO(SensorDTO sensorDTO) {
		if(sensorDTO.getName() == null || sensorDTO.getName().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo name en el body.");
		}
		
		if(sensorDTO.getCategory() == null || sensorDTO.getCategory().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo category en el body.");
		}
		
		if(sensorDTO.getMeta() == null || sensorDTO.getMeta().isBlank()) {
			throw new BadRequestException("Error: Falta el atributo meta en el body.");
		}

	}
}
