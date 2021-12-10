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

		return "test";
	}


}
