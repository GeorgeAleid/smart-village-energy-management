package com.renewableenergy.SHS.entity;

import com.renewableenergy.SHS.ShsApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class SmartMeter implements Observer {
	@Id
	@SequenceGenerator(
	name= "smartmeter_sequence", sequenceName= "smartmeter_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "smartmeter_sequence") 
	private long id;
	private String name;
	private double producedEnergy;
	private double consumedEnergyWithTariff;
	private double consumedEnergyWithoutTariff;
//	@OneToOne
//    @MapsId
//    @JoinColumn(name = "smart_home_id")
//	private SmartHome smartHome;
	
	public SmartMeter() {
	}
	
	public SmartMeter(String name) {
		this.name = name;
		this.producedEnergy = 0;
		this.consumedEnergyWithoutTariff = 0;
		this.consumedEnergyWithoutTariff = 0;
		//ShsApplication.sh.attach(this);
		//ShsApplication.sh.notifyObserver();
	}
	
	public void notifyme() {
		ShsApplication.sh.notifyObserver();
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
//	public SmartHome getSmartHome() {
//		return smartHome;
//	}
//	public void setSmartHome(SmartHome smartHome) {
//		this.smartHome = smartHome;
//	}

	@Override
	public String toString() {
		return "SmartMeter [id=" + id + ", name=" + name + ", producedEnergy=" + producedEnergy
				+ ", consumedEnergyWithTariff=" + consumedEnergyWithTariff + ", consumedEnergyWithoutTariff="
				+ consumedEnergyWithoutTariff + /*", smartHome=" + smartHome +*/ "]";
	}

	@Override
	public void update(double producedEnergy, double consumedEnergyWithTariff, double consumedEnergyWithoutTarif) {
//		ShsApplication.sm.setProducedEnergy(producedEnergy);
//		ShsApplication.sm.setConsumedEnergyWithTariff(consumedEnergyWithTariff);
//		ShsApplication.sm.setConsumedEnergyWithTariff(consumedEnergyWithoutTarif);
		this.consumedEnergyWithTariff = consumedEnergyWithTariff;
		this.consumedEnergyWithoutTariff = consumedEnergyWithoutTarif;
		this.producedEnergy = producedEnergy;
	}
}
