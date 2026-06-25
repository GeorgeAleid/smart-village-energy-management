package com.renewableenergy.SHS.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
import com.renewableenergy.SHS.repository.SmartMeterRepository;

@Service
public class SmartHomeService {
	
	private final SmartHomeRepository shr;
	@Autowired
	public SmartHomeService(SmartHomeRepository shr) {
		this.shr = shr;
		//attach(this.shr.getSmartMeter(null));
	}
	public void addSmartHome(String name,String location) {
		SmartHome v1 = new SmartHome(name,location);
		//entity smarthome add function that creats smartmeter
		//attach(v1.getSmartmeter());
		this.shr.save(v1);
	}
	 public void addSmartHomeObjekt(SmartHome sh) {
		 this.shr.save(sh);
	 }
	public void update(SmartHome sh) {
		this.shr.save(sh);
	}
	
	public List<SmartHome> getSmartHome(){
		return this.shr.findAll();
	}
	
	public SmartHome getSmartHome(long id) {
		return this.shr.getReferenceById(id);
	}
	public boolean deleteSmartHome(long id) {
		try {
			this.shr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
