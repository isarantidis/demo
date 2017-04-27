package com.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

	@GetMapping(path="/get")
	public HttpEntity<String> get() {
		return new HttpEntity<String>("Eisai megali lougkra");
	}
}
