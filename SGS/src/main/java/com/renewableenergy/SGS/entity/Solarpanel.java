package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Solarpanel extends CleanEnergyProducer{
	
	private int sunrise;
	
	public Solarpanel(Long id ,
			   String name,
			   double productionAmount,
			   boolean status,
			   String location,
			   int sunrise) {
		super(id,name,productionAmount,status,location);
		this.sunrise = sunrise;
}
	
	
	public Solarpanel() {

}

	public int getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

}
