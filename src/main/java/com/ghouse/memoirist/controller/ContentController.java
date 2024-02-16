package com.ghouse.memoirist.controller;

import com.ghouse.memoirist.dto.ContentDetails;
import com.ghouse.memoirist.dto.ContentRQ;
import com.ghouse.memoirist.dto.GenericStatus;
import com.ghouse.memoirist.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContentController {

	Logger log = LoggerFactory.getLogger(ContentController.class);

	@Autowired
	private ContentService contentService;
	
	@GetMapping(value = "/content", produces = "application/json")
	public ResponseEntity<ContentDetails> getContent(@RequestParam(required = false) String sectionDate,
			                                         @RequestParam(required = false) String sectionId) {
		log.info("getting content: " + sectionId +" sectionDate: "+sectionDate);
		ContentDetails content = contentService.getContent(sectionDate,sectionId);
		return new ResponseEntity<>(content, HttpStatus.OK);
		
	}
 
	@PostMapping(value = "/content", produces = "application/json")
	public ResponseEntity<GenericStatus> updateContent(@RequestBody ContentRQ contentRQ) {
		log.info("updating content: " + contentRQ);
		GenericStatus status = contentService.updateContent(contentRQ);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
