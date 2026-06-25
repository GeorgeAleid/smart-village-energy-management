
package com.renewableenergy.SHS.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
//import java.util.Set;


//tariff and SmartGrid from SGS muss be imported
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.ShsApplication;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table
public class SmartHome extends Observabel{
	@Id
	@SequenceGenerator(
	name= "smarthome_sequence", sequenceName= "smarthome_sequence",
	allocationSize = 1)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, 
	generator = "smarthome_sequence") 
	private long id;
	private String name;
	private String location;
	//private double electricityConsumed;
	private double electricityConsumedWithoutTariff;
	private double electricityConsumedWithTariff;
	private double electricityProduced;
	//private double realtimeCapasity;
	private LinkedList<Observer> observerlist = new LinkedList<Observer>();
//	@OneToMany
//	Set<HomeBattary> homebattarylist;
//	@OneToMany
//	Set<EnergyProducerinHome> energyproducerlist;
//	@OneToMany
//	Set<EnergyConsumer> energyconsumerlist;
//	 @OneToOne(cascade = CascadeType.ALL)
//	 @PrimaryKeyJoinColumn
//	private SmartMeter smartmeter;
//  @OneToOne
//	private Tariff tariff;
//	@ManyToOne
//	private SmartGrid smartGrid;
	public SmartHome() {
	}
	public SmartHome(String name,String location) {
		this.name = name;
		this.location = location;
		//this.electricityConsumed = 10;
		this.electricityConsumedWithoutTariff = 0;
		this.electricityConsumedWithTariff=0;
		this.electricityProduced = 0;
		//this.realtimeCapasity = 10;
//		this.homebattarylist = new HashSet<>();
//		this.energyproducerlist = new HashSet<>();
//		this.energyconsumerlist = new HashSet<>();
//		this.smartmeter = new SmartMeter("smartmeter for" + this.name, this.getElectricityProduced(),
//				this.electricityConsumedWithTariff,this.electricityConsumedWithoutTariff);
//		this.homebattarylist = null;
//		this.energyproducerlist = null;
//		this.energyconsumerlist = null;
//		this.smartmeter = null;
	}
	public void addToElectricityProduced(double num) {
		this.electricityProduced += num;
	}
	public void takeFromElectricityProduce(double sum) {
		this.electricityProduced -= sum;
	}
	public void addToElectricityConsumedWithTariff(double num) {
		this.electricityConsumedWithTariff += num;
	}
	public void addToElectricityConsumedWithoutTariff(double num) {
		this.electricityConsumedWithoutTariff += num;
	}
//	public void addToElectricityConsumed(double num) {
//		this.electricityConsumed += num;
//	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
//	public double getelectricityConsumed() {
//		return electricityConsumed;
//	}
//	public void setelectricityConsumed(double electricityConsumed) {
//		this.electricityConsumed = electricityConsumed;
//	}
	
	public double getElectricityConsumedWithoutTariff() {
		return electricityConsumedWithoutTariff;
	}
	public void setElectricityConsumedWithoutTariff(double electricityConsumedWithoutTariff) {
		this.electricityConsumedWithoutTariff = electricityConsumedWithoutTariff;
	}
	public double getElectricityConsumedWithTariff() {
		return electricityConsumedWithTariff;
	}
	public void setElectricityConsumedWithTariff(double electricityConsumedWithTariff) {
		this.electricityConsumedWithTariff = electricityConsumedWithTariff;
	}
	public double getElectricityProduced() {
		return electricityProduced;
	}
	public void setElectricityProduced(double electricityProduced) {
		this.electricityProduced = electricityProduced;
	}
//	public double getRealtimeCapasity() {
//		return realtimeCapasity;
//	}
//	public void setRealtimeCapasity(double realtimeCapasity) {
//		this.realtimeCapasity = realtimeCapasity;
//	}
//	public Set<HomeBattary> getHomebattarylist() {
//		return homebattarylist;
//	}
//	public void setHomebattarylist(Set<HomeBattary> homebattarylist) {
//		this.homebattarylist = homebattarylist;
//	}
//	public Set<EnergyProducerinHome> getEnergyproducerlist() {
//		return energyproducerlist;
//	}
//	public void setEnergyproducerlist(Set<EnergyProducerinHome> energyproducerlist) {
//		this.energyproducerlist = energyproducerlist;
//	}
//	public Set<EnergyConsumer> getEnergyconsumerlist() {
//		return energyconsumerlist;
//	}
//	public void setEnergyconsumerlist(Set<EnergyConsumer> energyconsumerlist) {
//		this.energyconsumerlist = energyconsumerlist;
//	}
//	public SmartMeter getSmartmeter() {
//		return smartmeter;
//	}
//	public void setSmartmeter(SmartMeter smartmeter) {
//		this.smartmeter = smartmeter;
//	}
	@Override
	public String toString() {
		return "SmartHome [id=" + id + ", name=" + name + ", location=" + location +/* ", electricityConsumed="
				+ electricityConsumed + */", electricityConsumedWithoutTariff=" + electricityConsumedWithoutTariff
				+ ", electricityConsumedWithTariff=" + electricityConsumedWithTariff + ", electricityProduced="
				+ electricityProduced +/* ", realtimeCapasity=" + realtimeCapasity + ", homebattarylist="
				+ homebattarylist + ", energyproducerlist=" + energyproducerlist + ", energyconsumerlist="
				+ energyconsumerlist +  ", smartmeter="+ smartmeter + */"]";
	}
	@Override
	public void attach(Observer o) {
		this.observerlist.add(o);
	}
	@Override
	public void detach(Observer o) {
		this.observerlist.remove(o);
		
	}
	@Override
	public void notifyObserver() {
		for(Observer v : this.observerlist) {
		//	v.update(ShsApplication.sh.getElectricityProduced(), ShsApplication.sh.getElectricityConsumedWithTariff(), ShsApplication.sh.getElectricityConsumedWithoutTariff());
			v.update(this.electricityProduced, this.electricityConsumedWithTariff, this.electricityConsumedWithoutTariff);
		}
	}
	
	public void druckObserver() {
		for(Observer a : observerlist) {
			System.out.println(a.toString());
		}
	}
	
}
