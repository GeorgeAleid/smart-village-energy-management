package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;


@MappedSuperclass
public class CleanEnergyProducer extends EnergyProducer {

	private String location;

	public CleanEnergyProducer(Long id , String name,
							   double productionAmount,
							   boolean status,
							   String location) {
		super(id,name,productionAmount,status);
		this.location = location;
	}

	public CleanEnergyProducer() {

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



}
