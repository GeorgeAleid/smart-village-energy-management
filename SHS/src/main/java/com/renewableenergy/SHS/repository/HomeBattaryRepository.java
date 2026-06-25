package com.renewableenergy.SHS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renewableenergy.SHS.entity.HomeBattary;

@Repository
public interface HomeBattaryRepository extends JpaRepository<HomeBattary, Long>{

}
