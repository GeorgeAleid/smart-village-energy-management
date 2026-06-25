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
import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SGS.service.SolarpanelService;

import java.util.Random;

@RestController
@RequestMapping("/solarpanel")
public class SolarpanelController {
	
	  Random random = new Random();
	
	  private final SolarpanelService solarpanelService ;
	  
	  public SolarpanelController (SolarpanelService solarpanelService) {
		  this.solarpanelService = solarpanelService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<Solarpanel>> getAllSolarpanel()
	  {
		  
		  List<Solarpanel> solarpanel = solarpanelService.findAllSolarpanel();
		 
		  double summe=0;
		  double randumSumme=0;
		  
		  for(Solarpanel panle : solarpanel) {
			  // Sunshine duration
			  panle.setSunrise(7);
			  
			  double pamount=panle.getProductionAmount();
			  double randomNumber=0;
			  if(panle.isStatus()) {
			  // Production (W/h)
			  randomNumber = random.nextInt(10) + 1;
			  pamount +=  randomNumber;
			  panle.setProductionAmount(pamount);
			  solarpanelService.updateSolarpanel(panle);			  
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
		  
		  return new ResponseEntity<>(solarpanel,HttpStatus.OK);
	  }
	  
	  @GetMapping("/find/{id}")
	  public ResponseEntity<Solarpanel> getSolarpanelById(@PathVariable("id") Long id )
	  {
		  Solarpanel solarpanel = solarpanelService.findSolarpanelByIdid(id);
		  return new ResponseEntity<>(solarpanel,HttpStatus.OK);
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Solarpanel> addSolarpanel(@RequestBody Solarpanel solarpanel){
		  Solarpanel newSolarpanel = solarpanelService.addSolarpanel(solarpanel);
		  return new ResponseEntity<>(newSolarpanel,HttpStatus.CREATED);
	  }
	  
	  @PutMapping("/update")
	  public ResponseEntity<Solarpanel> updateSolarpanel(@RequestBody Solarpanel solarpanel){
		  Solarpanel newSolarpanel = solarpanelService.updateSolarpanel(solarpanel);
		  return new ResponseEntity<>(newSolarpanel,HttpStatus.OK);
	  }
	  
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteSolarpanel(@PathVariable("id") Long id){
		  solarpanelService.deleteSolarpanel(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	  }

}
