package com.renewableenergy.SGS.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SGS.SgsApplication;
import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.service.BattaryService;

@RestController
@RequestMapping("/battery")
public class BattaryController {
	
	 private final BattaryService battaryService ;
	  
	  public BattaryController (BattaryService battaryService) {
		  this.battaryService = battaryService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Battary>> getAllBattary()
	  { 
		   
		  double rest_amount = SgsApplication.electricity_producedv - 
				  SgsApplication.lectricity_consumed ;
		  double batteries_Save  = 0;
		  List<Battary> battarys = battaryService.findAllBattary();
		  if(rest_amount>0) {
			  
			  double rest = rest_amount/2;
			 
				  for(Battary battary : battarys) {
					  
					  // charging -> battaryStatus is true
					  if(battary.isStatus()) {
						  battary.setSaveAmount(rest);
						  battaryService.updateBattary(battary);
						  batteries_Save = rest ;
						  
					  }
					  
					  // in Using -> battaryStatus is false
					  else {
						  double use = battary.getSaveAmount()-30;
						  battary.setSaveAmount(use);
					  }
					  SgsApplication.electrecity_incoming = SgsApplication.lectricity_consumed;						  

					} 	
			} 
		  
		  
		  
		 // SgsApplication.electrecity_incoming = 0;
		//  SgsApplication.electrecity_incoming = rest_amount;
		  
		  
		  return new ResponseEntity<>(battarys,HttpStatus.OK);
		  }

	  
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Battary> getBattaryById(@PathVariable("id") Long id )
	  {
		  Battary battary = battaryService.findBattaryByIdid(id);
		  return new ResponseEntity<>(battary,HttpStatus.OK);
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Battary> addBattary(@RequestBody Battary battary){
		  Battary newBattary = battaryService.addBattary(battary);
		  return new ResponseEntity<>(newBattary,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update")
	  public ResponseEntity<Battary> updateBattary(@RequestBody Battary battary){
		  Battary newBattary = battaryService.updateBattary(battary);
		  return new ResponseEntity<>(newBattary,HttpStatus.OK);
	  }
	  
}
