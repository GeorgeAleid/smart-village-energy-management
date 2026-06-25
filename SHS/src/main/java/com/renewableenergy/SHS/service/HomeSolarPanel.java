package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;

@Service
public class HomeSolarPanel{
	private final EnergyProducerinHomeRepository epihr;
	private final SmartHomeRepository shr;
	@Autowired
	public HomeSolarPanel(SmartHomeRepository shr,EnergyProducerinHomeRepository epihr) {
		this.epihr = epihr;
		this.shr = shr;
	}
	
	//@SuppressWarnings("deprecation")
	public void addHomeSolarPanel(String name) {
		//
		EnergyProducerinHome v1 = new EnergyProducerinHome(name);
		//v1.setSmarthome(shr.getById(id_smartHome));
		this.epihr.save(v1);
	}
	
	public void addHomeSolarPanle(EnergyProducerinHome epih) {
		this.epihr.save(epih);
	}
	public void update(EnergyProducerinHome epih) {
		this.epihr.save(epih);
	}
	
	public List<EnergyProducerinHome> getSolarPanel(String type){
		return this.epihr.findByType(type);
	}
	public boolean deleteSolarPanel(long id) {
		try {
			this.epihr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
