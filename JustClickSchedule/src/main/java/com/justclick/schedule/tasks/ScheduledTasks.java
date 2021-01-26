package com.justclick.schedule.tasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.justclick.schedule.entity.Clicks;
import com.justclick.schedule.repository.IClicksRepository;

@Component
public class ScheduledTasks {
	@Autowired
	IClicksRepository repository;
	@Scheduled(cron = "0 0/59 * * * * ")
	public void reportCurrentTime() throws FileNotFoundException {
		List<Clicks> click = new ArrayList<>();
		try {
			FileReader file = new FileReader("d:\\clicks.json");
			JsonElement datos =  JsonParser.parseReader(file);
			file.close();
			click = new Gson().fromJson(datos,new TypeToken<List<Clicks>>() {}.getType());
			repository.saveAll(click);

		} catch (Exception e) {
			System.out.println(e);
		}

		
	}

}
