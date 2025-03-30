package io.apiDevelopment.grupo2.proyectoFinal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.apiDevelopment.grupo2.proyectoFinal.model.SensorData;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long>{
	//List<SensorData> findByDatetimeBetweenAndSensorIdIn(LocalDateTime startDate, LocalDateTime endDate, List<Integer> sensorIds);
	List<SensorData> findByDatetimeBetweenAndSensorIdInAndSensorLocationCompanyId(LocalDateTime startDate, LocalDateTime endDate, List<Integer> sensorIds, Integer companyId);
}
