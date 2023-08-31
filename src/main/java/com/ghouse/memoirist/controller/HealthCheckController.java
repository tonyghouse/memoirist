package com.ghouse.memoirist.controller;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping(value="/", produces = "application/json")
	public ResponseEntity<String> checkHome() {
		return new ResponseEntity<>("Memoirist API Home: " + ZonedDateTime.now(), HttpStatus.OK);
	}

	@GetMapping(value="/health", produces = "application/json")
	public ResponseEntity<String> checkHealth() {
		return new ResponseEntity<>("Memoirist API Healthy: " + ZonedDateTime.now(), HttpStatus.OK);
	}

	@GetMapping(value="/liveness", produces = "application/json")
	public ResponseEntity<String> checkLiveness() {
		return new ResponseEntity<>("Memoirist API is Live: " + ZonedDateTime.now(), HttpStatus.OK);
	}

}
