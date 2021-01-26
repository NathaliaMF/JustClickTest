package com.justclick.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justclick.prueba.entity.ConsultResponse;
import com.justclick.prueba.entity.Urls;
import com.justclick.prueba.repository.IUrlsRepository;

@Service
public class ValidateService {
	
	@Autowired
	IUrlsRepository iUrlsRepository;
	
	
	public ConsultResponse consultElement( String element) {
		try {
			Urls url = iUrlsRepository.findByElement(element);
			if (url == null) {
				return new ConsultResponse("",404,"No se encontro el valor");
			}
			if(url.getUse() >=url.getMaximum()) {
				return new ConsultResponse("",404,"Se supero el limite de consulta");

			}
			url.setUse(url.getUse()+1);
			iUrlsRepository.save(url);
			return new ConsultResponse(url.getDirections(), 200, "Consulta Exitosa");
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
