package com.renewableenergy.SGS.controlers;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SGS.SgsApplication;
import com.renewableenergy.SGS.entity.Turbine;
import com.renewableenergy.SGS.service.TurbineService;

@RestController
@RequestMapping("/turbine")
public class TurbineController {
	 Random random = new Random();

	 @Value("${sgs.turbine.default-wind-speed:3.0}")
	 private double defaultWindSpeed;
	
	  private final TurbineService turbineService ;
	  
	  public TurbineController (TurbineService turbineService) {
		  this.turbineService = turbineService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Turbine>> getAllTurbine()
	  {
		  List<Turbine> turbine = turbineService.findAllTurbine();
		  
		  double summe=0;
		  double randumSumme=0;
		  for(Turbine turbin : turbine) {
			  double windspeed = defaultWindSpeed;
			  turbin.setWind_speed(windspeed);
			  
			  double pamount=turbin.getProductionAmount();
			  double randomNumber=0;
			  if(turbin.isStatus()) {
			  // Production (W/h)
			  randomNumber = random.nextInt(10)  * windspeed;
			  pamount +=  randomNumber;
			  turbin.setProductionAmount(pamount);
			  turbineService.updateTurbine(turbin);
			  }
			  
				// set electricity_producedv
			  summe += pamount;
			  randumSumme += randomNumber;
  
		  }
		  
		  if(SgsApplication.electricity_producedv == 0 ) {
			  SgsApplication.electricity_producedv += summe ;
		  }else {
			  SgsApplication.electricity_producedv +=  randumSumme;
		  }
		  
		  return new ResponseEntity<>(turbine,HttpStatus.OK);
	  }
	  
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Turbine> getTurbineById(@PathVariable("id") Long id )
	  {
		  Turbine turbine = turbineService.findTurbineByIdid(id);
		  return new ResponseEntity<>(turbine,HttpStatus.OK);
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Turbine> addTurbine(@RequestBody Turbine turbine){
		  Turbine newTurbine = turbineService.addTurbine(turbine);
		  return new ResponseEntity<>(newTurbine,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update")
	  public ResponseEntity<Turbine> updateTurbine(@RequestBody Turbine turbine){
		  Turbine newTurbine = turbineService.updateTurbine(turbine);
		  return new ResponseEntity<>(newTurbine,HttpStatus.OK);
	  }
	  
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteTurbine(@PathVariable("id") Long id){
		  turbineService.deleteTurbine(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }
}
