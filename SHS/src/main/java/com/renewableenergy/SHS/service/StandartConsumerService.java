package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
@Service
public class StandartConsumerService extends Creator {

	public StandartConsumerService(SmartHomeRepository shr, EnergyConsumerRepository ecr) {
		super(shr, ecr);
	}

	//@SuppressWarnings("deprecation")
	@Override
	public void factory(/*long id_smartHome,*/ String name, double consumedElectricity, String type) {
			EnergyConsumer ecih = new EnergyConsumer(name, consumedElectricity);
			ecih.setMystatus("allways");
			ecih.setType(type);
			//ecih.setSmarthome(super.getShs().getById(id_smartHome));
			super.getEcr().save(ecih);	
		
	}
	
	public void addStandartConsumer(EnergyConsumer ec) {
		super.getEcr().save(ec);
	}
	
	public List<EnergyConsumer> getEnergyConsumer(){
		return super.getEcr().findAll();
	}
	public void update(EnergyConsumer ec) {
		super.getEcr().save(ec);
	}
	public boolean deleteStandartConsumer(long id) {
		try {
			super.getEcr().deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
