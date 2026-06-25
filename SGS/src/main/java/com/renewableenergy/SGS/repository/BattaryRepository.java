package com.renewableenergy.SGS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.Battary;


public interface BattaryRepository extends JpaRepository<Battary,Long> {
	
	void deleteBattaryById(Long id);
	Battary findBattaryById(Long id);

}
