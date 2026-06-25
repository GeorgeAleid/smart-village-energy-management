package com.renewableenergy.SHS.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.renewableenergy.SHS.DTO.EnergyProducerinHomeDTO;
import com.renewableenergy.SHS.entity.EnergyProducerinHome;
import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.service.HomeSolarPanel;
import com.renewableenergy.SHS.service.HomeTurbine;
import com.renewableenergy.SHS.service.SmartHomeService;
@RestController
@RequestMapping(value = "api/v1/energy-producer")
public class CleanEnergyinHomeController {
	public final HomeSolarPanel hsp;
	public final HomeTurbine ht;
	public final SmartHomeService shs;
	public List<EnergyProducerinHome> liste_solarpanel;
	public List<EnergyProducerinHome> liste_homeTurbine;
	public List<SmartHome> liste_smarthome;
	public Random random;
	@Autowired
	CleanEnergyinHomeController(HomeSolarPanel hsp, HomeTurbine ht, SmartHomeService shs){
		this.shs = shs;
		this.hsp = hsp;
		this.ht = ht;
		this.liste_solarpanel = new LinkedList<EnergyProducerinHome>();
		this.liste_homeTurbine = new LinkedList<EnergyProducerinHome>();
		this.random = new Random();
	}
	
	@PostMapping(value = "/solar-panel-add")
	@CrossOrigin("*") 
	public boolean addHomeSolarPanel(@RequestBody EnergyProducerinHome request) {
		//you have to check for adding Exception
		try {
			hsp.addHomeSolarPanel(request.getName());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
	
	@GetMapping(value = "/solar-panel-show")
	@CrossOrigin("*") 
	public List<EnergyProducerinHome> getSolarPanel(){
		liste_solarpanel = hsp.getSolarPanel("solarpanel");
		liste_smarthome = shs.getSmartHome();
		double summe=0;
		double randumSumme=0;
		  
		  for(EnergyProducerinHome panle : liste_solarpanel) {
			  // Sunshine duration
			  //hsp.deleteSolarPanel(panle.getId());
			 // panle.setSunrise(LocalDateTime.of(2023, 07, 28, 5, 00, 00, 000000));
			 // panle.setSunset(LocalDateTime.of(2023, 07, 28, 20, 00, 00, 000000));
			 // double pamount=panle.getProducedElectrecity();
			 // double randomNumber=0;
			  if(panle.isStatus()) {
			  // Production (W/h)
			 // randomNumber = random.nextInt(10) + 1;
			 // pamount +=  randomNumber;
			 // panle.setProducedElectrecity(pamount);
			  double res = panle.calculateProducSolarPanel();
			  for(SmartHome a : liste_smarthome) {
				  a.addToElectricityProduced(res);
				  shs.update(a);
				  }
			  hsp.update(panle);
			 //service for the variabels from smartmeter
			  }
			// set electricity_producedv
//			  summe += pamount;
//			  randumSumme += randomNumber;
		  }
		  //muss noch angepasst werden
//		  SmartHome sh = shs.getSmartHome(request.getId_smartHome());
//		  if(sh.getElectricityProduced() == 0 ) {
//			  sh.addToElectricityProduced(summe);
//		  }else {
//			  sh.addToElectricityProduced(randumSumme);
//		  }
		 // return liste_solarpanel;
		return hsp.getSolarPanel("solarpanel");
	}
	 @PutMapping("/solar-panel-update")
	 @CrossOrigin("*") 
	  public boolean updateSolarpanel(@RequestBody EnergyProducerinHome request){
		 try {
			 hsp.update(request);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
	  }
	@PostMapping(value = "/solar-panel-remove")
	public boolean removeHomeSolarPanel(@RequestBody EnergyProducerinHomeDTO request) {
		//you have to check for adding Exception
		try {
			hsp.deleteSolarPanel(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
	
	@PostMapping(value = "/turbine-add")
	@CrossOrigin("*") 
	public boolean addHomeTurbine(@RequestBody EnergyProducerinHome request) {
		//you have to check for adding Exception
		try {
			ht.addHomeTurbine(request.getName());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	@GetMapping(value = "/turbine-show")
	@CrossOrigin("*") 
	public List<EnergyProducerinHome> getHomeTurbine(){
		liste_homeTurbine = ht.getHomeTurbine("turbine");
		liste_smarthome = shs.getSmartHome();
//		double summe=0;
//		double randumSumme=0;
		  
		  for(EnergyProducerinHome turbine : liste_homeTurbine) {
			  // Sunshine duration
			 // ht.deleteHomeTurbine(turbine.getId());
//			  turbine.setWind_speed(50);
			  
//			  double pamount=turbine.getProducedElectrecity();
//			  double randomNumber=0;
			  if(turbine.isStatus()) {
			  // Production (W/h)
				double res =   turbine.calculateProducTurbine();
				 for(SmartHome a : liste_smarthome) {
					  a.addToElectricityProduced(res);
					  shs.update(a);
					  }
//			  randomNumber = random.nextInt(10) + 1;
//			  pamount +=  randomNumber;
//			  turbine.setProducedElectrecity(pamount);
			  ht.update(turbine);
			  }
			// set electricity_producedv
//			  summe += pamount;
//			  randumSumme += randomNumber;
		  }
		  //muss noch angepasst werden
//		  SmartHome sh = shs.getSmartHome(request.getId_smartHome());
//		  if(sh.getElectricityProduced() == 0 ) {
//			  sh.addToElectricityProduced(summe);
//		  }else {
//			  sh.addToElectricityProduced(randumSumme);
//		  }
		  return ht.getHomeTurbine("turbine");
		 // return liste_homeTurbine;
		//return ht.getHomeTurbine(request.getType());
	}
	 @PutMapping("/turbine-update")
	 @CrossOrigin("*") 
	  public boolean updateHomeTurbine(@RequestBody EnergyProducerinHome request){
		 try {
			 ht.update(request);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
	  }
	@PostMapping(value = "/turbine-remove")
	public boolean removeHomeTurbine(@RequestBody EnergyProducerinHome request) {
		//you have to check for adding Exception
		try {
			ht.deleteHomeTurbine(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}

}
