package com.renewableenergy.SHS.DTO;

import java.util.Set;

import com.renewableenergy.SHS.entity.EnergyConsumer;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.entity.SmartMeter;

public class SmartHomeDTO {
	 long id;
	 String name;
	 String location;
	 double neededElectricity;
	 double electricityConsumedWithoutTariff;
	 double electricityConsumedWithTariff;
	 double electricityProduced;
	 double realtimeCapasity;
	 Set<HomeBattary> homebattarylist;
	 Set<EnergyProducerinHome> energyproducerlist;
	 Set<EnergyConsumer> energyconsumerlist;
	 SmartMeter smartmeter;
	public SmartHomeDTO() {
	}

	public SmartHomeDTO(long id, String name, String location, double neededElectricity,
			double electricityConsumedWithoutTariff, double electricityConsumedWithTariff, double electricityProduced,
			double realtimeCapasity, Set<HomeBattary> homebattarylist, Set<EnergyProducerinHome> energyproducerlist,
			Set<EnergyConsumer> energyconsumerlist, SmartMeter smartmeter) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.neededElectricity = neededElectricity;
		this.electricityConsumedWithoutTariff = electricityConsumedWithoutTariff;
		this.electricityConsumedWithTariff = electricityConsumedWithTariff;
		this.electricityProduced = electricityProduced;
		this.realtimeCapasity = realtimeCapasity;
		this.homebattarylist = homebattarylist;
		this.energyproducerlist = energyproducerlist;
		this.energyconsumerlist = energyconsumerlist;
		this.smartmeter = smartmeter;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getNeededElectricity() {
		return neededElectricity;
	}
	public void setNeededElectricity(double neededElectricity) {
		this.neededElectricity = neededElectricity;
	}
	public double getElectricityConsumedWithoutTariff() {
		return electricityConsumedWithoutTariff;
	}
	public void setElectricityConsumedWithoutTariff(double electricityConsumedWithoutTariff) {
		this.electricityConsumedWithoutTariff = electricityConsumedWithoutTariff;
	}
	public double getElectricityConsumedWithTariff() {
		return electricityConsumedWithTariff;
	}
	public void setElectricityConsumedWithTariff(double electricityConsumedWithTariff) {
		this.electricityConsumedWithTariff = electricityConsumedWithTariff;
	}
	public double getElectricityProduced() {
		return electricityProduced;
	}
	public void setElectricityProduced(double electricityProduced) {
		this.electricityProduced = electricityProduced;
	}
	public double getRealtimeCapasity() {
		return realtimeCapasity;
	}
	public void setRealtimeCapasity(double realtimeCapasity) {
		this.realtimeCapasity = realtimeCapasity;
	}
	public Set<HomeBattary> getHomebattarylist() {
		return homebattarylist;
	}
	public void setHomebattarylist(Set<HomeBattary> homebattarylist) {
		this.homebattarylist = homebattarylist;
	}
	public Set<EnergyProducerinHome> getEnergyproducerlist() {
		return energyproducerlist;
	}
	public void setEnergyproducerlist(Set<EnergyProducerinHome> energyproducerlist) {
		this.energyproducerlist = energyproducerlist;
	}
	public Set<EnergyConsumer> getEnergyconsumerlist() {
		return energyconsumerlist;
	}
	public void setEnergyconsumerlist(Set<EnergyConsumer> energyconsumerlist) {
		this.energyconsumerlist = energyconsumerlist;
	}
	public SmartMeter getSmartmeter() {
		return smartmeter;
	}
	public void setSmartmeter(SmartMeter smartmeter) {
		this.smartmeter = smartmeter;
	}
	
	
	 
}
