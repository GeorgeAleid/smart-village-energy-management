package com.renewableenergy.SGS.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renewableenergy.SGS.entity.Solarpanel;
import com.renewableenergy.SGS.entity.Turbine;
import com.renewableenergy.SGS.repository.SolarpanelRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SolarpanelService {

	@Autowired
	private final SolarpanelRepository solarpanelRepository;
	
	SolarpanelService(SolarpanelRepository solarpanelRepository) {
		this.solarpanelRepository = solarpanelRepository;
	}
	
	public Solarpanel addSolarpanel (Solarpanel solarpanel) {
		return solarpanelRepository.save(solarpanel);
	}
	
	public List<Solarpanel> findAllSolarpanel(){
		return solarpanelRepository.findAll();
	}
	
	public Solarpanel updateSolarpanel(Solarpanel solarpanel) {
		return solarpanelRepository.save(solarpanel);
	}
	
	public Solarpanel findSolarpanelByIdid(Long id ) {

		return solarpanelRepository.findSolarpanelById(id);
		
	}
	
	public void deleteSolarpanel (Long id) {
		solarpanelRepository.deleteSolarpanelById(id);
	}
}
