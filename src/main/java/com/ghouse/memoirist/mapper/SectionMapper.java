package com.ghouse.memoirist.mapper;

import java.time.format.DateTimeFormatter;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.entity.Section;
import com.ghouse.memoirist.util.GenericUtil;

@Mapper(componentModel = "spring")
public interface SectionMapper {

	@Mapping(target = "sectionId", source = "section.sectionId")
	@Mapping(target = "sectionTitle", source = "section",qualifiedByName = "convertToTitle")
	@BeanMapping(ignoreByDefault = false)
	SectionDetails toSectionDetails(Section section);
	
	@Named("convertToTitle")
	public static String convertToTitle(Section section) {
		if ("DATE".equals(section.getSectionNameType())) {
			String date = section.getSectionDate().format(DateTimeFormatter.ofPattern(GenericUtil.DD_MMM_YYYY));
			return date;
		} else {
			return section.getSectionName();
		}
	}
}