package io.apiDevelopment.grupo2.proyectoFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import io.apiDevelopment.grupo2.proyectoFinal.dto.SensorDTO;
import io.apiDevelopment.grupo2.proyectoFinal.model.Sensor;
import io.apiDevelopment.grupo2.proyectoFinal.repository.SensorRepository;

public class SensorServiceImpl implements SensorService{

	@Autowired
	private SensorRepository sensorRepository;
	
	@Override
	public Sensor createSensor(SensorDTO sensor) {
		return sensorRepository.save(new Sensor(null, sensor));
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
				sensor.get().getApiKey());
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
