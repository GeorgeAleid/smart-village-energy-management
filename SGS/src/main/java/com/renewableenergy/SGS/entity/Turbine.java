package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table	
public class Turbine extends CleanEnergyProducer {
	
	public Turbine(Long id ,
				   String name,
				   double productionAmount,
				   boolean status,
				   String location,
				   double wind_speed) {
			super(id,name,productionAmount,status,location);
			this.wind_speed = wind_speed;
	}
	
	public Turbine() {

}

	private double wind_speed;

	public double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
}
