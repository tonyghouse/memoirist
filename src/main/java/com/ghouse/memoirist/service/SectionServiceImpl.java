package com.ghouse.memoirist.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.dto.SectionRQ;
import com.ghouse.memoirist.entity.Content;
import com.ghouse.memoirist.entity.Section;
import com.ghouse.memoirist.mapper.SectionMapper;
import com.ghouse.memoirist.repo.SectionRepo;
import com.ghouse.memoirist.util.GenericUtil;

@Service
public class SectionServiceImpl implements SectionService {

	Logger log = LoggerFactory.getLogger(SectionServiceImpl.class);

	@Autowired
	private SectionRepo sectionRepo;

	@Autowired
	private SectionMapper sectionMapper;

	@Override
	public List<SectionDetails> getTopSections(String userId) {

		// default total sections needed 12
		int defaultNumbTopSections = 12;

		Pageable pageable = PageRequest.of(0, 5, Sort.by("sectionName"));

		Page<Section> namedSections = sectionRepo.getTopSections(userId, "NAME", pageable);

		int remaingNumbMoreSections = defaultNumbTopSections - namedSections.getContent().size();

		List<LocalDate> sectionDates = getListOfDates(remaingNumbMoreSections);

		List<SectionDetails> sectionDetailsList = new ArrayList<>(defaultNumbTopSections);

		// TODO
		List<Section> datedSections = sectionRepo.getBySectionDateIn(sectionDates);
		Map<LocalDate, Section> datedSectionsMap = datedSections.stream()
				.collect(Collectors.toMap(Section::getSectionDate, Function.identity()));

		for (LocalDate date : sectionDates) {
			Section section = datedSectionsMap.get(date);
			String sectionId = section != null ? section.getSectionId() : null;
			SectionDetails sectionDetails = new SectionDetails(sectionId, "DATE", GenericUtil.convertToString(date),
					GenericUtil.convertToTitle(date));
			sectionDetailsList.add(sectionDetails);
		}

		for (Section section : namedSections) {
			SectionDetails sectionDetails = sectionMapper.toSectionDetails(section);
			sectionDetailsList.add(sectionDetails);
		}

		return sectionDetailsList;
	}

	private List<LocalDate> getListOfDates(int remaingNumbMoreSections) {
		List<LocalDate> listOfDates = new ArrayList<>(remaingNumbMoreSections);
		LocalDate currentDate = LocalDate.now();
		listOfDates.add(currentDate);
		for (int i = 1; i < remaingNumbMoreSections; i++) {
			listOfDates.add(currentDate.minusDays(i));
		}
		return listOfDates;
	}

	@Override
	public SectionDetails addSection(SectionRQ sectionRQ) {
		Section newSection = new Section();
		newSection.setUserId(sectionRQ.getUserId());
		if (sectionRQ.getSectionDate() != null) {
			newSection.setSectionDate(GenericUtil.getLocalDate(sectionRQ.getSectionDate()));
			newSection.setSectionNameType("DATE");
		} else {
			newSection.setSectionName(sectionRQ.getSectionName());
			newSection.setSectionNameType("NAME");
		}
		Section section = sectionRepo.save(newSection);
		SectionDetails sectionDetails = sectionMapper.toSectionDetails(section);
		return sectionDetails;
	}

}
