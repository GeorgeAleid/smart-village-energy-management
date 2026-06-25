package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;

public class EnergyConsumerDTO {
	long id;
	String name;
	double consumedElectrecity;
	String mystatus;
	SmartHome smarthome;
	boolean isStandart; 
	long id_smartHome;
	
	public EnergyConsumerDTO(long id_smartHome, long id, String name, double consumedElectrecity, String mystatus, SmartHome smarthome,
			boolean	isStandart) {
		this.id_smartHome = id_smartHome;
		this.id = id;
		this.name = name;
		this.consumedElectrecity = consumedElectrecity;
		this.mystatus = mystatus;
		this.smarthome = smarthome;
		this.isStandart = isStandart;
	}
	public EnergyConsumerDTO() {
		
	}
	
	public long getId_smartHome() {
		return id_smartHome;
	}
	public void setId_smartHome(long id_smartHome) {
		this.id_smartHome = id_smartHome;
	}
	public boolean isStandart() {
		return isStandart;
	}
	public void setStandart(boolean isStandart) {
		this.isStandart = isStandart;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getConsumedElectrecity() {
		return consumedElectrecity;
	}
	public void setConsumedElectrecity(double consumedElectrecity) {
		this.consumedElectrecity = consumedElectrecity;
	}
	public String getMystatus() {
		return mystatus;
	}
	public void setMystatus(String mystatus) {
		this.mystatus = mystatus;
	}
	public SmartHome getSmarthome() {
		return smarthome;
	}
	public void setSmarthome(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
	
	
}
