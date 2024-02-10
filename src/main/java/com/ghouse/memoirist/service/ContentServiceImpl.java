package com.ghouse.memoirist.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghouse.memoirist.dto.Block;
import com.ghouse.memoirist.dto.ContentDetails;
import com.ghouse.memoirist.dto.ContentRQ;
import com.ghouse.memoirist.dto.GenericStatus;
import com.ghouse.memoirist.entity.Content;
import com.ghouse.memoirist.entity.Section;
import com.ghouse.memoirist.repo.ContentRepo;
import com.ghouse.memoirist.repo.SectionRepo;
import com.ghouse.memoirist.util.GenericUtil;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepo contentRepo;

	@Autowired
	private SectionRepo sectionRepo;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ContentDetails getContent(String sectionDate, String sectionId) {
		Section section;
		if (sectionId != null) {
			section = sectionRepo.getBySectionId(sectionId);
		} else {
			section = sectionRepo.getBySectionDate(GenericUtil.getLocalDate(sectionDate));
		}

		if (section == null) {
			return new ContentDetails(sectionId, sectionDate, null, Collections.emptyList());
		}

		String sectionTitle = inferSectionTitle(section.getSectionName(), section.getSectionDate());

		JsonNode contentsOrder = section.getContentsOrder();

		List<Content> contents = contentRepo.getBySectionId(sectionId);
		List<String> contentIds = convertToList(contentsOrder);

		Map<String, Content> contentsMap = contents.stream()
				.collect(Collectors.toMap(Content::getContentId, Function.identity()));

		List<Block> blocks = new ArrayList<>(contents.size());

		for (String contentId : contentIds) {
			Content content = contentsMap.get(contentId);
			Block block = new Block(content.getContentId(), content.getContentType(), content.getData());
			blocks.add(block);
		}

		return new ContentDetails(sectionId, sectionDate, sectionTitle, blocks);
	}

	private String inferSectionTitle(String sectionName, LocalDate sectionDate) {
		System.out.println("section date: "+sectionDate);
		if (sectionDate != null) {
			return GenericUtil.convertToTitle(sectionDate);
		}
		return sectionName;
	}

	@Override
	public GenericStatus updateContent(ContentRQ contentRQ) {
		String userId = contentRQ.getUserId();
		String sectionId = contentRQ.getSectionId();
		String sectionDate = contentRQ.getSectionDate();
		Section section;

		if (sectionId != null) {
			section = sectionRepo.getBySectionId(sectionId);
		} else{
			section = getOrCreateSection(sectionDate, userId);
		}
		if (section == null) {
			return new GenericStatus("FAILURE");
		}

		List<Block> blocks = contentRQ.getBlocks();

		List<Content> contents = new ArrayList<>(blocks.size());
		List<String> contentsOrder = new ArrayList<>(blocks.size());

		for (Block block : blocks) {
			Content content = new Content();
			content.setContentId(block.getId());
			content.setContentType(block.getType());
			content.setData(block.getData());
			content.setSectionId(section.getSectionId());
			contents.add(content);
			contentsOrder.add(block.getId());
		}

		JsonNode contentsOrderJson = convertToJsonNode(contentsOrder);
		System.out.println("contentOrderJson: "+contentsOrderJson);
		section.setContentsOrder(contentsOrderJson);
		sectionRepo.save(section);
		contentRepo.saveAll(contents);

		return new GenericStatus("SUCCESS");
	}

	private Section getOrCreateSection(String sectionDate, String userId) {
		LocalDate parsedSectionDate = GenericUtil.getLocalDate(sectionDate);
		List<Section> sections = sectionRepo.getBySectionDateAndUserId(parsedSectionDate,userId);
		if (!sections.isEmpty()) {
			return  sections.get(0);
		}

		Section newSection = new Section();
		newSection.setUserId(userId);
		newSection.setSectionDate(parsedSectionDate);
		newSection.setSectionName("Day"+parsedSectionDate.toString());
		newSection.setSectionNameType("DATE");
		return sectionRepo.save(newSection);
	}

	private List<String> convertToList(JsonNode node) {
		try {
			List<String> list = objectMapper.readerFor(new TypeReference<List<String>>() {
			}).readValue(node);
			return list;

		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	private JsonNode convertToJsonNode(List<String> list) {
		try {
			String jsonStr = objectMapper.writeValueAsString(list);
            return objectMapper.readTree(jsonStr);

		} catch (Exception e) {
			return null;
		}
	}

}
