package com.renewableenergy.SHS.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.HomeBattaryRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;

@Service
public class HomeBattaryService {
	private final HomeBattaryRepository hbr;
	private final SmartHomeRepository shr;
	@Autowired
	public HomeBattaryService( SmartHomeRepository shr,HomeBattaryRepository hbr) {
		this.shr = shr;
		this.hbr = hbr;
	}
	//@SuppressWarnings("deprecation")
	public void addHomeBattary(/*long id_smartHome, */String name,double maxCapacity) {
		HomeBattary v1 = new HomeBattary(name, maxCapacity);
		//v1.setSmartHome(argument)
		//v1.setSmarthome(shr.getById(id_smartHome));
		this.hbr.save(v1);
	}
	
	public void updateBattary(HomeBattary hb) {
		this.hbr.save(hb);
	}
	
	public List<HomeBattary> getBattary(){
		return this.hbr.findAll();
	}
	public boolean deleteHomeBattary(long id) {
		try {
			this.hbr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
