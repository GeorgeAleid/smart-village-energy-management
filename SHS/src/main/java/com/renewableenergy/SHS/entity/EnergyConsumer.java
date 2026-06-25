package com.renewableenergy.SHS.entity;

import java.time.LocalDateTime;
import java.util.Random;
//import java.util.Set;

import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.MQTT.MqttSubscriberImpl;

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
public class EnergyConsumer {
	@Id
	@SequenceGenerator(
	name= "energyconsumer_sequence", sequenceName= "energyconsumer_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "energyconsumer_sequence") 
	private long id;
	private String name;
	private double consumedElectrecity;
	private double totalConsume;
	private String tariff;
//	public enum Status{
//		ON,
//		OFF,
//		ALLWAYS
//	}
	private String mystatus;
	private String type;
//	@ManyToOne
//	SmartHome smarthome;
	public EnergyConsumer() {
	}
	public EnergyConsumer(String name, double consumedElectrecity) {
			this.name = name;
			this.consumedElectrecity = consumedElectrecity;
			this.totalConsume = 0;
			this.tariff = MqttSubscriberImpl.tariff != null ? MqttSubscriberImpl.tariff : "not defined";
	}
	public double calculateConsumeStandart() {
		this.totalConsume += consumedElectrecity;
		return consumedElectrecity;
//		if (ShsApplication.consumedEnergyWithoutTariff == 0) {
//			ShsApplication.consumedEnergyWithTariff = consumedElectrecity;
//		}else {
//			ShsApplication.consumedEnergyWithTariff += consumedElectrecity;
//		}
	}
	public double calculateConsumeVariabel() {
		this.totalConsume += consumedElectrecity * 2;
		return consumedElectrecity * 2;
//		if (ShsApplication.consumedEnergyWithoutTariff == 0) {
//			ShsApplication.consumedEnergyWithoutTariff = consumedElectrecity;
//		}else {
//			ShsApplication.consumedEnergyWithoutTariff +=  consumedElectrecity * 2;
//		}
	}
	public void addConsumedElectricity(double num) {
		this.consumedElectrecity += num;
	}
	
	public double getTotalConsume() {
		return totalConsume;
	}
	public void setTotalConsume(double totalConsume) {
		this.totalConsume = totalConsume;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
    public String getTariff() {
		return tariff;
	}
	public void setTariff(String tariff) {
		this.tariff = tariff;
	}
	//	public SmartHome getSmarthome() {
//		return smarthome;
//	}
//	public void setSmarthome(SmartHome smarthome) {
//		this.smarthome = smarthome;
//	}
	@Override
	public String toString() {
		return "EnergyConsumer [id=" + id + ", name=" + name + ", consumedElectrecity=" + consumedElectrecity
				+ ", mystatus=" + mystatus + ", type=" + type + /*", smarthome=" + smarthome + */"]";
	}

}
