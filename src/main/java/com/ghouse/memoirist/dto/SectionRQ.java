package com.ghouse.memoirist.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SectionRQ {

	private String userId;

	private String sectionDate;

	private String sectionName;


}
