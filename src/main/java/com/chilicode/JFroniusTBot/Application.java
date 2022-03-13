package com.chilicode.JFroniusTBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		History history = History.getInstance();
		history.setRunning(false);
		history.setCurrentPower(0f);
		history.setLastResponse(null);
		SpringApplication.run(Application.class, args);
	}

}
