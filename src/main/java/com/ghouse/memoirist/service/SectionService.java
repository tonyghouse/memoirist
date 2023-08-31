package com.ghouse.memoirist.service;

import java.util.List;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.dto.SectionRQ;

public interface SectionService {
	
	public List<SectionDetails> getTopSections(String userId);

	public SectionDetails addSection(SectionRQ sectionRQ);

}
