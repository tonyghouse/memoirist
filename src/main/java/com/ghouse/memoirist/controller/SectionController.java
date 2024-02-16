package com.ghouse.memoirist.controller;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.dto.SectionRQ;
import com.ghouse.memoirist.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

	Logger log = LoggerFactory.getLogger(SectionController.class);

	@Autowired
	private SectionService sectionService;

	@GetMapping(value = "/sections/top/{userId}", produces = "application/json")
	public ResponseEntity<List<SectionDetails>> getTopSections(@PathVariable String userId) {
		List<SectionDetails> sections = sectionService.getTopSections(userId);

		return new ResponseEntity<>(sections, HttpStatus.OK);
	}

	@GetMapping(value = "/sectionDetails", produces = "application/json")
	public ResponseEntity<SectionDetails> getSectionDetails(@RequestParam(required = false) String sectionId,
															@RequestParam(required = false) String sectionDate) {
		log.info("Getting section details by sectionId: "+sectionId +" sectionDate: "+sectionDate);
		SectionDetails section = sectionService.getSectionDetails(sectionId,sectionDate);
		return new ResponseEntity<>(section, HttpStatus.OK);
	}

	@PostMapping(value = "/sections", produces = "application/json")
	public ResponseEntity<SectionDetails> addSection(@RequestBody SectionRQ sectionRQ) {
		log.info("adding section: "+sectionRQ);
		SectionDetails section = sectionService.addSection(sectionRQ);
		return new ResponseEntity<>(section, HttpStatus.OK);
	}

}
