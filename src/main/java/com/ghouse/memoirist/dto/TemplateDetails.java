package com.ghouse.memoirist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class TemplateDetails {
	
	@JsonProperty("templateId")
	private String templateId;
	
	@JsonProperty("templateName")
	private String templateName;
	
	@JsonProperty("author")
	private String author;
	

}
