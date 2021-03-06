package com.chilicode.JFroniusTBot;


import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

import com.chilicode.JFroniusTBot.model.PowerFlowRealtimeData;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fb")
public class Controller {

	History history;

	@PostMapping(path = "/postData", produces = "application/json")
	public String postData(@RequestBody String jsonString) {

		return jsonString;
	}

	@GetMapping(path = "/getData", produces = "application/json")
	public String getData() {

		FroniusController fc = new FroniusController();
		String fd = fc.getData();
		
		TelegramBotController tbc = new TelegramBotController();
		tbc.sendMessage(fd);

		return "sent :" + fd;
	}

	@GetMapping(path = "/tellMeCurrentPower", produces = "application/json")
	public String tellMeCurrentPower() {

		FroniusController fc = new FroniusController();
		PowerFlowRealtimeData data = fc.getPowerFlowRealtimeData();
		String currentPower = fc.getCurrentPowerMessage(data);		

		TelegramBotController tbc = new TelegramBotController();
		tbc.sendMessage(currentPower);

		return "sent :" + currentPower;
	}

	@GetMapping(path = "/tellMeTotalPower", produces = "application/json")
	public String tellMeTotalPower() {

		FroniusController fc = new FroniusController();
		PowerFlowRealtimeData data = fc.getPowerFlowRealtimeData();
		String totalPower = fc.getTotalPowerMessage(data);		

		TelegramBotController tbc = new TelegramBotController();
		tbc.sendMessage(totalPower);

		return "sent :" + totalPower;
	}




	@GetMapping(path = "/status", produces = "application/json")
	public String getStatus() {

		

		FroniusController fc = new FroniusController();
		String fd = fc.getSatus();

		TelegramBotController tb = new TelegramBotController();


		return fd + "\n" + tb.getTcid() + "\n" + tb.getTbk();
	}

	@GetMapping(path = "/ready", produces = "application/json")
	public String getReady() {

		History history = History.getInstance();
		

		FroniusController fc = new FroniusController();
		PowerFlowRealtimeData data = fc.getPowerFlowRealtimeData();

		Float cP = 0.0f;
		Float pP = 0.0f;
		String message = "";

		if ( history != null){
			pP = history.getCurrentPower();
		}
		history.setLastResponse(new Date());
		if (data == null && history.getRunning() == true){
			history.setRunning(false);
			history.setCurrentPower(0.0f); 
			message = "nichts geht mehr .... gute nacht";
		}else{

			cP = fc.getCurrentPower(data);

			if ( cP < 1000.0f && history.getRunning() == false ) {
				//set running
				history.setLastResponse(new Date());
				history.setCurrentPower(cP);
				history.setRunning(true);
				message = "up and running  --- " + fc.getCurrentPowerMessage(data);
			}

			if ( java.lang.Math.abs(cP - pP) > 1000f){
				history.setLastResponse(new Date());
				history.setCurrentPower(cP);
				history.setRunning(true);
	
				
				if ( between(cP, 1000f, 3000f)){
					message = "start washing --- " + fc.getCurrentPowerMessage(data);
				}	
				
				if ( between(cP, 3000f, 10000f)){
					message = "charge car --- " + fc.getCurrentPowerMessage(data);
				}	
				
			}
			
		}
		
		if (!message.equals("")){
			TelegramBotController tbc = new TelegramBotController();
			tbc.sendMessage(message);
		}
		
		
		return "sent :" + message;
	}
	

	public static boolean between(Float variable, Float minValueInclusive, Float maxValueInclusive) {
		return variable >= minValueInclusive && variable <= maxValueInclusive;
	}

	public static void setEnv(String key, String value) {
		try {
			Map<String, String> env = System.getenv();
			Class<?> cl = env.getClass();
			Field field = cl.getDeclaredField("m");
			field.setAccessible(true);
			Map<String, String> writableEnv = (Map<String, String>) field.get(env);
			writableEnv.put(key, value);
		} catch (Exception e) {
			throw new IllegalStateException("Failed to set environment variable", e);
		}
	}


}
