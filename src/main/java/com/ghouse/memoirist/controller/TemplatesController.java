package com.ghouse.memoirist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghouse.memoirist.dto.TemplateDetails;
import com.ghouse.memoirist.service.TemplateService;

@RestController
public class TemplatesController {

	Logger log = LoggerFactory.getLogger(TemplatesController.class);

	@Autowired
	private TemplateService templateService;

	@GetMapping(value = "/tempates/top/", produces = "application/json")
	public ResponseEntity<List<TemplateDetails>> getTopTemplates() {
		List<TemplateDetails> templates = templateService.getTopTemplates();
		return new ResponseEntity<>(templates, HttpStatus.OK);
	}

}
