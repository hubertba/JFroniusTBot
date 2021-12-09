package com.chilicode.JFroniusTBot;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class Controller {

	@PostMapping(path = "/fire", produces = "application/json")
	public String recieveOrderWebHook(@RequestBody String jsonString) {

		System.out.println("fire");

		return jsonString;
	}
}