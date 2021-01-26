package com.justclick.prueba.models;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Clicks implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Cookie cookies;
	private Header headers;
	private String param;
	private int statusCode;
	private Date date;
	
	public Clicks() {
		cookies = new Cookie();
		headers = new Header();
	}

}
