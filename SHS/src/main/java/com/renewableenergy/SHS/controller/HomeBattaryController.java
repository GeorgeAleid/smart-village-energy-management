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

import com.renewableenergy.SHS.DTO.HomeBattaryDTO;
import com.renewableenergy.SHS.entity.HomeBattary;
import com.renewableenergy.SHS.service.HomeBattaryService;
@RestController
@RequestMapping(value = "api/v1/home-battary")
public class HomeBattaryController {
		public final HomeBattaryService hb;
		//add smarthomeservice 
		@Autowired
		HomeBattaryController(HomeBattaryService hb){
			this.hb = hb;
		}
		
		@PostMapping(value = "/home-battary-add")
		@CrossOrigin("*") 
		public boolean addHomeBattary(@RequestBody HomeBattary request) {
			//you have to check for adding Exception
			try {
				//SmartHome v1 = smarthomeservice.getbyid(request.getid) 
				hb.addHomeBattary(request.getName(), request.getMaxCapacity() );
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		    return true;
		}
		@GetMapping(value = "/home-battary-show")
		@CrossOrigin("*") 
		public List<HomeBattary> getHomeBattary(){
			List<HomeBattary> hblist = new LinkedList<HomeBattary>();
			hblist=hb.getBattary();
			for( HomeBattary battary : hblist) {
				if(battary.checkNeededElectricity()/* && ShsApplication.producedEnergy > 5*/) {
					battary.charging();
				}else {
					battary.setCharging(false);
				}
				hb.updateBattary(battary);
			}
			return hb.getBattary();
		}
		
		 @PutMapping("/home-battary-update")
		 @CrossOrigin("*") 
		  public boolean updateHomeBattary(@RequestBody HomeBattary request){
			 try {
				 hb.updateBattary(request);
				}catch(Exception e) {
					e.printStackTrace();
					return false;
				}
			    return true;
		  }
		@PostMapping(value = "/home-battary-remove")
		public boolean removeHomeBattary(@RequestBody HomeBattaryDTO request) {
			//you have to check for adding Exception
			try {
				hb.deleteHomeBattary(request.getId());
			}catch(Exception e) {
				e.printStackTrace();
				return false;
				
			}
		    return true;
		}
}

