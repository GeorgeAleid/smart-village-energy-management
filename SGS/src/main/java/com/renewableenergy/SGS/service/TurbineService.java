package com.renewableenergy.SGS.service;

import java.util.*;
import java.util.Optional.*;
import  com.renewableenergy.SGS.exception.*;
import com.renewableenergy.SGS.repository.TurbineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Turbine;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TurbineService {

	@Autowired
	private final TurbineRepository turbineRepository;
	TurbineService(TurbineRepository turbineRepository) {
		this.turbineRepository = turbineRepository;
	}
	
	public Turbine addTurbine (Turbine turbine) {
		return turbineRepository.save(turbine);
	}
	
	public List<Turbine> findAllTurbine(){
		return turbineRepository.findAll();
	}
	
	public Turbine updateTurbine(Turbine turbine) {
		return turbineRepository.save(turbine);
	}
	
	public Turbine findTurbineByIdid(Long id ) {
		//	orElseThrow(()-> new TurbineNotFoundException("Turbine with id :" + id + "was not found!"));
		return turbineRepository.findTurbineById(id);
		
	}
	
	public void deleteTurbine (Long id) {
		 turbineRepository.deleteTurbineById(id);
	}
}
