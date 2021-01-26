package com.justclick.schedule.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "clicks" )
public class Clicks implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
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
