package com.renewableenergy.SHS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.repository.EnergyConsumerRepository;
import com.renewableenergy.SHS.repository.SmartHomeRepository;

public abstract class Creator{
	private final EnergyConsumerRepository ecr;
	private final SmartHomeRepository shr;
	
	@Autowired
	public Creator(SmartHomeRepository shr,EnergyConsumerRepository ecr) {
		this.ecr = ecr;
		this.shr = shr;
	}


	public abstract void factory(/*long id_smartHome, */String name, double consumedElectricity
			, String type);

	public EnergyConsumerRepository getEcr() {
		return ecr;
	}

	public SmartHomeRepository getShs() {
		return shr;
	}
	
	
}
