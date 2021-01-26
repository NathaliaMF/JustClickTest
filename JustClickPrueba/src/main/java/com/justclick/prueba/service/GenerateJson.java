package com.justclick.prueba.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.justclick.prueba.models.Clicks;

@Service
public class GenerateJson {

	public void buildJson(String cookie, String element, String method, String host, String browser, int status) throws IOException {
		List<Clicks> clicks = new ArrayList<>();
		try {
			FileReader file = new FileReader("d:\\clicks.json");
			JsonElement datos =  JsonParser.parseReader(file);
			file.close();
			System.out.println(datos);
			clicks = new Gson().fromJson(datos,new TypeToken<List<Clicks>>() {}.getType());
		}catch(FileNotFoundException ex) {
			ex.getMessage();
		}
		Clicks click = new Clicks();
		click.getCookies().setName(cookie);
		click.getHeaders().setBrowser(browser);
		click.getHeaders().setHost(host);
		click.getHeaders().setMethod(method);
		click.setParam(element);
		click.setStatusCode(status);
		click.setDate(new Date());
		clicks.add(click);
		FileWriter filew = new FileWriter("d:\\clicks.json");
		filew.write(new Gson().toJson(clicks));
		filew.flush();
		filew.close();
	}

}
