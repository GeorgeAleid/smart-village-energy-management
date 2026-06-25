package com.renewableenergy.SHS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;
@Service
public class VariabelConsumerService extends Creator {

	public VariabelConsumerService(SmartHomeRepository shr,EnergyConsumerRepository ecr) {
		super(shr,ecr);
	}

	@Override
	public void factory(/*long id_smartHome,*/String name, double consumedElectricity, String type) {
			EnergyConsumer ecih = new EnergyConsumer(name, consumedElectricity);
			ecih.setMystatus("on");
			ecih.setType(type);
			//muss noch angepasst werden
//			if(getTariffInfo()) {
//				ecih.setMystatus(Status.ON);
//			}else {
//				ecih.setMystatus(Status.OFF);
//			}
			//ecih.setSmarthome(super.getShs().getById(id_smartHome));
			super.getEcr().save(ecih);	
	}
	
	public void update(EnergyConsumer ec) {
		super.getEcr().save(ec);
	}
	
	public void addVariabelConsumer(EnergyConsumer ec) {
		super.getEcr().save(ec);
	}
	public List<EnergyConsumer> getEnergyConsumer(){
		return super.getEcr().findAll();
	}
	public boolean deleteVariabelConsumer(long id) {
		try {
			super.getEcr().deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getTariffInfo() {
		//hier wird deklariert mit einem boolean ob 
		// status = ON or OFF ist
		return true;
	}

}
