package com.renewableenergy.SGS.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.renewableenergy.SGS.SgsApplication;
import com.renewableenergy.SGS.entity.SmartGrid;
import com.renewableenergy.SGS.service.SmartGridService;

@RestController
@RequestMapping("/smartgrid")
public class SmartGridController {
	
	  private final SmartGridService smartGridService ;
	  
	  public SmartGridController (SmartGridService smartGridService) {
		  this.smartGridService = smartGridService;
	  }
	  
	  @GetMapping("/all")
	  public ResponseEntity<List<SmartGrid>> getAllSmartGrid()
	  {
		  
		  List<SmartGrid> smartGrid = smartGridService.findAllSolarpanel();
		  for(SmartGrid smartgrid : smartGrid) {
			  SgsApplication.lectricity_consumed = smartgrid.getLectricityConsumed();
			  // electrecity_incoming
			  SgsApplication.electrecity_incoming = smartgrid.getLectricityConsumed();
			  
			  smartgrid.setElectrecityIncoming(SgsApplication.electricity_producedv);
			// electricity_producedv
			  smartgrid.setElectricityProducedv(SgsApplication.electricity_producedv);
			  
			// electricity_producedv
			 
			  
		  }
		  return new ResponseEntity<>(smartGrid,HttpStatus.OK);
	  }
	  
	  
	  @PutMapping("/update")
	  public ResponseEntity<SmartGrid> updateSolarpanel(@RequestBody SmartGrid smartGrid){
		  SmartGrid newSmartGrid = smartGridService.updateSolarpanel(smartGrid);
		  // electrecity_incoming
		 newSmartGrid.setElectrecityIncoming(SgsApplication.electrecity_incoming);
		  
		// electricity_producedv
		  newSmartGrid.setElectricityProducedv(SgsApplication.electricity_producedv);
		  
		// electricity_producedv
		 // newSmartGrid.setLectricityConsumed(SgsApplication.lectricity_consumed);
		  
		  
		  return new ResponseEntity<>(newSmartGrid,HttpStatus.OK);
	  }
	  
}
