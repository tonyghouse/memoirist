package com.ghouse.memoirist.service;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.dto.SectionRQ;

import java.util.List;

public interface SectionService {
	
	public List<SectionDetails> getTopSections(String userId);

	public SectionDetails addSection(SectionRQ sectionRQ);

    SectionDetails getSectionDetails(String sectionId, String sectionDate);
}
