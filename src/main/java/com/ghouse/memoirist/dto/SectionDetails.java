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
public class SectionDetails {
	
	@JsonProperty("sectionId")
	private String sectionId;
	
	@JsonProperty("sectionNameType")
	private String sectionNameType;
	
	@JsonProperty("sectionDate")
	private String sectionDate;
	
	@JsonProperty("sectionTitle")
	private String sectionTitle;

}
