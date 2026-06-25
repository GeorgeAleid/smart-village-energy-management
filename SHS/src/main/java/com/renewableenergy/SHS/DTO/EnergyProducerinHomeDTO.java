package com.renewableenergy.SHS.DTO;

import java.time.LocalDateTime;

public class EnergyProducerinHomeDTO {
	long id_smartHome;
	 long id;
	 String name;
	 boolean status;
	 double consumedElectrecity;
	 double producedElectrecity;
	 double realtimeCapacity;
	 double maxOutput;
	 double consume;
	 double efficiency;
	 LocalDateTime sunrise;
	 LocalDateTime sunset;
	 double wind_speed;
	 String type;
	public EnergyProducerinHomeDTO(long id_smartHome, long id, String name, boolean status, double consumedElectrecity,
			double producedElectrecity, double realtimeCapacity, double maxOutput, double consume, double efficiency,
			LocalDateTime sunrise, LocalDateTime sunset, String type) {
		this.id_smartHome = id_smartHome;
		this.id = id;
		this.name = name;
		this.status = status;
		this.consumedElectrecity = consumedElectrecity;
		this.producedElectrecity = producedElectrecity;
		this.realtimeCapacity = realtimeCapacity;
		this.maxOutput = maxOutput;
		this.consume = consume;
		this.efficiency = efficiency;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.type = type;
	}
	public EnergyProducerinHomeDTO(long id, String name, boolean status, double consumedElectrecity,
			double producedElectrecity, double realtimeCapacity, double maxOutput, double consume, double efficiency,
			double wind_speed, String type) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.consumedElectrecity = consumedElectrecity;
		this.producedElectrecity = producedElectrecity;
		this.realtimeCapacity = realtimeCapacity;
		this.maxOutput = maxOutput;
		this.consume = consume;
		this.efficiency = efficiency;
		this.wind_speed = wind_speed;
		this.type = type;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getConsumedElectrecity() {
		return consumedElectrecity;
	}
	public void setConsumedElectrecity(double consumedElectrecity) {
		this.consumedElectrecity = consumedElectrecity;
	}
	public double getProducedElectrecity() {
		return producedElectrecity;
	}
	public void setProducedElectrecity(double producedElectrecity) {
		this.producedElectrecity = producedElectrecity;
	}
	public double getRealtimeCapacity() {
		return realtimeCapacity;
	}
	public void setRealtimeCapacity(double realtimeCapacity) {
		this.realtimeCapacity = realtimeCapacity;
	}
	public double getMaxOutput() {
		return maxOutput;
	}
	public void setMaxOutput(double maxOutput) {
		this.maxOutput = maxOutput;
	}
	public double getConsume() {
		return consume;
	}
	public void setConsume(double consume) {
		this.consume = consume;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	public LocalDateTime getSunrise() {
		return sunrise;
	}
	public void setSunrise(LocalDateTime sunrise) {
		this.sunrise = sunrise;
	}
	public LocalDateTime getSunset() {
		return sunset;
	}
	public void setSunset(LocalDateTime sunset) {
		this.sunset = sunset;
	}
	public double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	 
	 
}
