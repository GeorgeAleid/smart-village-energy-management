package com.renewableenergy.SGS.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table
public class SmartGrid {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date Date;
	
	private double electricityProducedv;
	
	private double electrecityIncoming;
	
	private double lectricityConsumed;


	public SmartGrid( java.util.Date date, double electricityProducedv, double electrecityIncoming,
			double lectricityConsumed) {
		super();
		Date = date;
		this.electricityProducedv = electricityProducedv;
		this.electrecityIncoming = electrecityIncoming;
		this.lectricityConsumed = lectricityConsumed;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public double getElectricityProducedv() {
		return electricityProducedv;
	}

	public void setElectricityProducedv(double electricityProducedv) {
		this.electricityProducedv = electricityProducedv;
	}

	public double getElectrecityIncoming() {
		return electrecityIncoming;
	}

	public void setElectrecityIncoming(double electrecityIncoming) {
		this.electrecityIncoming = electrecityIncoming;
	}

	public double getLectricityConsumed() {
		return lectricityConsumed;
	}

	public void setLectricityConsumed(double lectricityConsumed) {
		this.lectricityConsumed = lectricityConsumed;
	}

	public SmartGrid() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
  
	@Override
	public String toString() {
		return "SmartGrid [id=" + id + ", Date=" + Date + ", electricityProducedv=" + electricityProducedv
				+ ", electrecityIncoming=" + electrecityIncoming + ", lectricityConsumed=" + lectricityConsumed + "]";
	}

}
