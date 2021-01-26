package com.justclick.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.justclick.prueba.entity.Urls;

@Repository
public interface IUrlsRepository extends JpaRepository<Urls, Integer>{
	
	public Urls findByElement(String element);
	
}
