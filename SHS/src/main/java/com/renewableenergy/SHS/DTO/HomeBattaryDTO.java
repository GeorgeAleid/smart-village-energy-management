package com.renewableenergy.SHS.DTO;

import com.renewableenergy.SHS.entity.SmartHome;

public class HomeBattaryDTO {
	long id_smartHome; 
	 long id;
	 String name;
	 double maxCapacity;
	 double consumedElectrictiy;
	 double realtimeCapacity;
	 int reachedMax;
	 boolean charging;
	 SmartHome smarthome;
	public HomeBattaryDTO() {
	}
	public HomeBattaryDTO(long id_smartHome, long id, String name, double maxCapacity, double consumedElectrictiy, double realtimeCapacity,
			int reachedMax, boolean charging, SmartHome smarthome) {
		this.id_smartHome = id_smartHome;
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.consumedElectrictiy = consumedElectrictiy;
		this.realtimeCapacity = realtimeCapacity;
		this.reachedMax = reachedMax;
		this.charging = charging;
		this.smarthome = smarthome;
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
	public double getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public double getConsumedElectrictiy() {
		return consumedElectrictiy;
	}
	public void setConsumedElectrictiy(double consumedElectrictiy) {
		this.consumedElectrictiy = consumedElectrictiy;
	}
	public double getRealtimeCapacity() {
		return realtimeCapacity;
	}
	public void setRealtimeCapacity(double realtimeCapacity) {
		this.realtimeCapacity = realtimeCapacity;
	}
	public int getReachedMax() {
		return reachedMax;
	}
	public void setReachedMax(int reachedMax) {
		this.reachedMax = reachedMax;
	}
	public boolean isCharging() {
		return charging;
	}
	public void setCharging(boolean charging) {
		this.charging = charging;
	}
	public SmartHome getSmarthome() {
		return smarthome;
	}
	public void setSmarthome(SmartHome smarthome) {
		this.smarthome = smarthome;
	}
//	public Status getMystatus() {
//		return mystatus;
//	}
//	public void setMystatus(Status mystatus) {
//		this.mystatus = mystatus;
//	}
	 
}
