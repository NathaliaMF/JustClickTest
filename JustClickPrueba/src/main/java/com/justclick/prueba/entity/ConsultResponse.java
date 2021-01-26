package com.justclick.prueba.entity;

import lombok.Data;

@Data
public class ConsultResponse  {

	private String results;
	private Integer code;
	private String message;



	public ConsultResponse(String results,Integer code , String message) {
		this.results = results;
		this.code = code;
		this.message = message;
	}

	public ConsultResponse() {
		super();
	}

}