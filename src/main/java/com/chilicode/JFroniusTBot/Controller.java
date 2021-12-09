package com.chilicode.JFroniusTBot;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class Controller {

	@PostMapping(path = "/suckit", produces = "application/json")
	public String recieveData(@RequestBody String jsonString) {

		System.out.println("fire");

		return jsonString;
	}

	@GetMapping(path = "/fire", produces = "application/json")
	public String retrieveData(@RequestBody String jsonString) {

		System.out.println("fire");

		return jsonString;
	}

}