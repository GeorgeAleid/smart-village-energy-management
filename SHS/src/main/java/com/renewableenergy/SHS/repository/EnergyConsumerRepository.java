package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.EnergyConsumer;


@Repository
public interface EnergyConsumerRepository extends JpaRepository<EnergyConsumer, Long>{

}
