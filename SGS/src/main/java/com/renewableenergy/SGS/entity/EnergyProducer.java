package com.renewableenergy.SGS.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@MappedSuperclass
public abstract class EnergyProducer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private double productionAmount;
	
	public EnergyProducer() {
		
	}

	public EnergyProducer(Long id ,String name, double productionAmount, boolean status) {
		this.id = id ;
		this.name = name;
		this.productionAmount = productionAmount;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getProductionAmount() {
		return productionAmount;
	}

	public void setProductionAmount(double productionAmount) {
		this.productionAmount = productionAmount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
		
}
