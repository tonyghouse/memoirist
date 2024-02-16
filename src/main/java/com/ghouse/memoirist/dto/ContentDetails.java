package com.ghouse.memoirist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
