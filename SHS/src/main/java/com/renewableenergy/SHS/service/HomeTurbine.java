package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;

@Service
public class HomeTurbine {
	private final EnergyProducerinHomeRepository epihr;
	private final SmartHomeRepository shr;
	@Autowired
	public HomeTurbine(SmartHomeRepository shr,EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
		this.shr = shr;
	}
	//@SuppressWarnings("deprecation")
	public void addHomeTurbine(String name) {
		EnergyProducerinHome v1 = new EnergyProducerinHome(name, 0.0 );
		//v1.setSmarthome(shr.getById(id_smartHome));
		this.epihr.save(v1);
	}
	public void addHomeTurbine(EnergyProducerinHome epih) {
		this.epihr.save(epih);
	}
	
	public List<EnergyProducerinHome> getHomeTurbine(String type){
		return this.epihr.findByType(type);
	}
	public void update(EnergyProducerinHome epih) {
		this.epihr.save(epih);
	}
	public boolean deleteHomeTurbine(long id) {
		try {
			this.epihr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
