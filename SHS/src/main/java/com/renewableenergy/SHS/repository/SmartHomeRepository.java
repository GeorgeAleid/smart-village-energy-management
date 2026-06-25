package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.SmartHome;
import com.renewableenergy.SHS.entity.SmartMeter;

@Repository
public interface SmartHomeRepository extends JpaRepository<SmartHome, Long>{
	// SmartMeter getSmartMeter(SmartHome sh);
}
