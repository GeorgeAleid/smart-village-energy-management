package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.OneToOne;

public class SmartMeterDTO {
	long id_smartHome;
	 long id;
	 String name;
	 double producedEnergy;
	 double consumedEnergyWithTariff;
	 double consumedEnergyWithoutTariff;
	 SmartHome smartHome;
	public SmartMeterDTO() {
	}
	public SmartMeterDTO(long id_smartHome, long id, String name, double producedEnergy, double consumedEnergyWithTariff,
			double consumedEnergyWithoutTariff, SmartHome smartHome) {
		this.id_smartHome = id_smartHome;
		this.id = id;
		this.name = name;
		this.producedEnergy = producedEnergy;
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTariff;
		this.smartHome = smartHome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_smartHome() {
		return id_smartHome;
	}
	public void setId_smartHome(long id_smartHome) {
		this.id_smartHome = id_smartHome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProducedEnergy() {
		return producedEnergy;
	}
	public void setProducedEnergy(double producedEnergy) {
		this.producedEnergy = producedEnergy;
	}
	public double getConsumedEnergyWithTariff() {
		return consumedEnergyWithTariff;
	}
	public void setConsumedEnergyWithTariff(double consumedEnergyWithTariff) {
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
	}
	public double getConsumedEnergyWithoutTariff() {
		return consumedEnergyWithoutTariff;
	}
	public void setConsumedEnergyWithoutTariff(double consumedEnergyWithoutTariff) {
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTariff;
	}
	public SmartHome getSmartHome() {
		return smartHome;
	}
	public void setSmartHome(SmartHome smartHome) {
		this.smartHome = smartHome;
	}
	
	 
}
