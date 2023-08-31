package com.ghouse.memoirist.dto;

import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContentRQ {
	private String sectionId;
	private String sectionDate;
	private String userId;

	private List<Block> blocks = Collections.emptyList();
	private List<String> contentsOrder = Collections.emptyList();

}
