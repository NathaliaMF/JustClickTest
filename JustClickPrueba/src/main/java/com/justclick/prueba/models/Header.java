package com.justclick.prueba.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Header  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String browser;
	private String host;
	private String method;

}
