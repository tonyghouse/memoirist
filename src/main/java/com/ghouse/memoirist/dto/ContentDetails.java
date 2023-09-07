package com.ghouse.memoirist.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ContentDetails {
	
	@JsonProperty("sectionId")
	private String sectionId;
	
	@JsonProperty("sectionDate")
	private String sectionDate;
	
	@JsonProperty("sectionTitle")
	private String sectionTitle;
	
	@JsonProperty("blocks")
	private List<Block> blocks;

}
