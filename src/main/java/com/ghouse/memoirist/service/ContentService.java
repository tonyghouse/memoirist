package com.ghouse.memoirist.service;

import com.ghouse.memoirist.dto.ContentDetails;
import com.ghouse.memoirist.dto.ContentRQ;
import com.ghouse.memoirist.dto.GenericStatus;

public interface ContentService {

	GenericStatus updateContent(ContentRQ contentRQ);

	ContentDetails getContent(String sectionDate, String sectionId);
	


}
