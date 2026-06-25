package com.renewableenergy.SHS.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;
import com.renewableenergy.SHS.service.SmartHomeService;
import com.renewableenergy.SHS.service.SmartMeterService;

@RestController
@RequestMapping(value = "api/v1/smart-meter")
public class SmartMeterController {
	public final SmartMeterService sms;
	public final SmartHomeService shs;
	List <SmartMeter> smlist = new LinkedList<SmartMeter>();
	List <SmartHome> shlist = new LinkedList<SmartHome>();
	@Autowired
	SmartMeterController(SmartMeterService sms, SmartHomeService shs){
		this.sms = sms;
		this.shs = shs;
	}
	
	@PostMapping(value = "/smart-meter-add")
	@CrossOrigin("*") 
	public boolean addSmartMeter(@RequestBody SmartMeter request) {
		//you have to check for adding Exception
		try {
			sms.addSmartMeter(request.getName(), request.getProducedEnergy(),
					request.getConsumedEnergyWithTariff(), request.getConsumedEnergyWithoutTariff());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}
	
	@GetMapping(value = "/smart-meter-show")
	@CrossOrigin("*") 
	public List<SmartMeter> getSmartMeter(){
		smlist = sms.getSmartMeter();
		shlist = shs.getSmartHome();
		for(SmartMeter s : smlist) {
//			s.setConsumedEnergyWithoutTariff(ShsApplication.consumedEnergyWithoutTariff);
//			s.setConsumedEnergyWithTariff(ShsApplication.consumedEnergyWithTariff);
//			s.setProducedEnergy(ShsApplication.producedEnergy);
			for(SmartHome sh : shlist) {
				s.setConsumedEnergyWithoutTariff(sh.getElectricityConsumedWithoutTariff());
				s.setConsumedEnergyWithTariff(sh.getElectricityConsumedWithTariff());
				s.setProducedEnergy(sh.getElectricityProduced());
			}
//			s.notifyme();
//			System.out.println("done");
			sms.update(s);
		}
		
		return sms.getSmartMeter();
	}
	 @PutMapping("/smart-meter-update")
	 @CrossOrigin("*") 
	  public boolean updateSmartMeter(@RequestBody SmartMeter request){
		 try {
			 	sms.update(request);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
	  }
	@PostMapping(value = "/smart-meter-remove")
	public boolean removeSmartMeter(@RequestBody SmartMeter request) {
		//you have to check for adding Exception
		try {
			sms.deleteSmartMeter(request.getId());
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	    return true;
	}
}
