package com.ghouse.memoirist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionDetails {
	
	@JsonProperty("sectionId")
	private String sectionId;
	
	@JsonProperty("sectionNameType")
	private String sectionNameType;
	
	@JsonProperty("sectionDate")
	private String sectionDate;
	
	@JsonProperty("sectionTitle")
	private String sectionTitle;

	@JsonProperty("sectionTitleDesc")
	private String sectionTitleDesc;

}
