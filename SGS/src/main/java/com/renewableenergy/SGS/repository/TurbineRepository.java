package com.renewableenergy.SGS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.Turbine;

public interface TurbineRepository extends JpaRepository<Turbine,Long> {
	void deleteTurbineById(Long id);
	
	Turbine findTurbineById(Long id);
}
