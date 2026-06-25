package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.SmartMeter;

@Repository
public interface SmartMeterRepository extends JpaRepository<SmartMeter, Long>{

}
