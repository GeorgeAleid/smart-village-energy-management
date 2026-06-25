package com.renewableenergy.SGS.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Battary;
import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SGS.repository.BattaryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BattaryService {

	@Autowired
	private final BattaryRepository battaryRepository;
	BattaryService(BattaryRepository battaryRepository) {
		this.battaryRepository = battaryRepository;
	}
	
	public Battary addBattary (Battary battary) {
		return battaryRepository.save(battary);
	}
	
	public List<Battary> findAllBattary(){
		return battaryRepository.findAll();
	}
	
	public Battary updateBattary(Battary battary) {
		return battaryRepository.save(battary);
	}
	
	public Battary findBattaryByIdid(Long id ) {

		return battaryRepository.findBattaryById(id);
		
	}
	
	public void deleteBattarye (Long id) {
		battaryRepository.deleteBattaryById(id);
	}
	
}
