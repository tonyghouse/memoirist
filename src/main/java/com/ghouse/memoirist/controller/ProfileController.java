package com.ghouse.memoirist.controller;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;
import com.ghouse.memoirist.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

	Logger log = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService profileService;

	@GetMapping(value="/profile/permissions/{userName}" , produces = "application/json")
	public ResponseEntity<List<String>> getProfilePermissions(@PathVariable String userName) {
		List<String> permissions = profileService.getProfilePermissions(userName);
		return new ResponseEntity<>(permissions, HttpStatus.OK);
	}

	@PostMapping(value="/profile/new", produces = "application/json")
	public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
		Profile savedProfile = profileService.addProfile(profile);
		return new ResponseEntity<>(savedProfile, HttpStatus.OK);
	}

	@GetMapping(value="/profile/{userName}", produces = "application/json")
	public ResponseEntity<ProfileRS> getProfile(@PathVariable String userName) {
		ProfileRS profileRS = profileService.getProfile(userName);
		log.info("profile: "+profileRS);
		return new ResponseEntity<>(profileRS, HttpStatus.OK);
	}

}
