package com.justclick.prueba.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justclick.prueba.entity.ConsultResponse;
import com.justclick.prueba.service.GenerateJson;
import com.justclick.prueba.service.ValidateService;

@RestController
@RequestMapping(value = "/JustClick")
public class Endpoint {
	@Autowired
	private ValidateService service;
	@Autowired
	private GenerateJson jsonService;

	@GetMapping("/link/{element}")
	public ResponseEntity<ConsultResponse> searchElement ( @PathVariable String element, HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			String idName = UUID.randomUUID().toString();
			System.out.println(idName);
			Cookie cookie = new Cookie("name", idName);
			ConsultResponse consult =  service.consultElement(element);
			if (consult.getCode() ==200) {
				response.addCookie(cookie);
				jsonService.buildJson(idName, element,request.getMethod(), request.getRemoteHost(), request.getHeader("sec-ch-ua")!=null?request.getHeader("sec-ch-ua"):"", response.getStatus());
				return new ResponseEntity<>(consult, HttpStatus.OK);
			}else{
				return new ResponseEntity<>(consult, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(new ConsultResponse("",500,"Ocurrio un error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
