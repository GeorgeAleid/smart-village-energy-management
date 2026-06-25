package com.renewableenergy.SHS.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.repository.EnergyProducerinHomeRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
import com.renewableenergy.SHS.repository.SmartMeterRepository;

@Service
public class SmartMeterService {
	private final SmartMeterRepository smr;
	private final SmartHomeRepository shr;
	@Autowired
	public SmartMeterService(SmartHomeRepository shr, SmartMeterRepository smr) {
		this.smr = smr;
		this.shr = shr;
	}
	public void addSmartMeter(String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff) {
		SmartMeter v1 = new SmartMeter(name);
		this.smr.save(v1);
	}
	
	public void addSmartMeterObjekt(SmartMeter sm) {
		this.smr.save(sm);
	}
	
	public List<SmartMeter> getSmartMeter(){
		LinkedList<SmartMeter> smlist = new LinkedList<SmartMeter>();
		for(SmartMeter s : smlist) {
			s.notifyme();
			update(s);
		}
		ShsApplication.sh.druckObserver();
		return this.smr.findAll();
	}
	public void update(SmartMeter sm) {
		this.smr.save(sm);
	}
	public boolean deleteSmartMeter(long id) {
		try {
			this.smr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
