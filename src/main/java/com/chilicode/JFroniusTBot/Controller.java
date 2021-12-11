package com.chilicode.JFroniusTBot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/fb")
public class Controller {

	@PostMapping(path = "/postData", produces = "application/json")
	public String postData(@RequestBody String jsonString) {

		return jsonString;
	}

	@GetMapping(path = "/getData", produces = "application/json")
	public String getData() {

		FroniusController fc = new FroniusController();
		FroniusData fd = fc.getData();

		TelegramBotController tbc = new TelegramBotController();
		tbc.sendMessage(fd.getPower());

		return "test";
	}


	@GetMapping(path = "/status", produces = "application/json")
	public String getStatus() {

		FroniusController fc = new FroniusController();
		String fd = fc.getSatus();

		TelegramBotController tb = new TelegramBotController();


		return fd + "\n" + tb.getTcid() + "\n" + tb.getTbk();
	}


}
