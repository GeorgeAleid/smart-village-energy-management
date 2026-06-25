package com.renewableenergy.SGS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Tariff {
	@Id
	@SequenceGenerator(
	name= "tariff_sequence", sequenceName= "tariff_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "tariff_sequence") 
	private long id;
}
