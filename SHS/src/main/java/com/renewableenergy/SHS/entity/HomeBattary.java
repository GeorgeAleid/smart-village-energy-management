package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
//import java.util.Set;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.entity.SmartHome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class HomeBattary {
	@Id
	@SequenceGenerator(
	name= "homebattary_sequence", sequenceName= "homebattary_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "homebattary_sequence") 
	private long id;
	private String name;
	private double maxCapacity;
	private double consumedElectrictiy;
	private double realtimeCapacity;
	private int reachedMax;
	private boolean charging;
//	@ManyToMany(mappedBy = "battarys")
//	Set<SmartHome> smarthomes;
//	@ManyToOne
//	SmartHome smarthome;
//	public enum Status{
//		GOOD,
//		MIDDEL, 
//		BAD
//	}
//	Status mystatus;
	public HomeBattary() {
	}
	
	public HomeBattary(String name, double maxCapacity) {
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.consumedElectrictiy = 0;
		this.realtimeCapacity = 0;
		this.reachedMax = 0;
		this.charging = false;
	}
	
	public void charging() {
		this.charging = true;
		//ShsApplication.producedEnergy -= 5;
		this.realtimeCapacity += 5;
	}
	
	public boolean checkNeededElectricity() {
		return realtimeCapacity<maxCapacity;
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

//	public SmartHome getSmarthome() {
//		return smarthome;
//	}
//
//	public void setSmarthome(SmartHome smarthome) {
//		this.smarthome = smarthome;
//	}

//	public Status getMystatus() {
//		return mystatus;
//	}
//
//	public void setMystatus(Status mystatus) {
//		this.mystatus = mystatus;
//	}

	@Override
	public String toString() {
		return "HomeBattary [id=" + id + ", name=" + name + ", maxCapacity=" + maxCapacity + ", consumedElectrictiy="
				+ consumedElectrictiy + ", realtimeCapacity=" + realtimeCapacity + ", reachedMax=" + reachedMax
				+ ", charging=" + charging + /*", smarthome=" + smarthome + ", mystatus=" + mystatus +*/ "]";
	}
	
}
