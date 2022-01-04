package com.chilicode.JFroniusTBot;


import com.chilicode.JFroniusTBot.model.PowerFlowRealtimeData;

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
		String currentPower = fc.getCurrentPowerMessage(data);		

		Float cP = fc.getCurrentPower(data);	

		String message = "";
		TelegramBotController tbc = new TelegramBotController();

		tbc.sendMessage(currentPower);
		
		if ( cP > 0.0f) {
			//set running
			//history.setRunning(true);
			message = "up and running";
		}else{
			//history.setRunning(false);
			message = "not running";
		}

		if ( !message.equals("")){
			tbc.sendMessage(message);
		}

		if ( between(cP, 0.1f, 1000f)){
			message = "warming up"; 
		}	

		if ( between(cP, 1000f, 3000f)){
			message = "start washing"; 
		}	

		if ( between(cP, 3000f, 10000f)){
			message = "charge car"; 
		}	
		tbc.sendMessage(message);
		
		return "sent :" + message;
	}


	public static boolean between(Float variable, Float minValueInclusive, Float maxValueInclusive) {
		return variable >= minValueInclusive && variable <= maxValueInclusive;
	}


}
