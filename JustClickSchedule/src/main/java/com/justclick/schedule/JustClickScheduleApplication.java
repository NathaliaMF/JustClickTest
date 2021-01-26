package com.justclick.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JustClickScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustClickScheduleApplication.class, args);
	}

}
