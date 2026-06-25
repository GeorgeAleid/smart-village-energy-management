package com.renewableenergy.SGS.entity;

import java.time.LocalDateTime;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
   public class Battary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name ; 
	
	private String location ; 

	private double capacity;
	
	private double saveAmount;
	
	private boolean status;

	public Battary( String name, String location, double capacity, double saveAmount, boolean status) {
		super();

		this.location = location;
		this.capacity = capacity;
		this.saveAmount = saveAmount;
		this.status = status;
		this.name=name;
	}

	public Battary() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(double saveAmount) {
		this.saveAmount = saveAmount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Battary [id=" + id + ", location=" + location + ", capacity=" + capacity + ", saveAmount=" + saveAmount
				+ ", status=" + status + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
