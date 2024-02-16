package com.ghouse.memoirist.mapper;

import com.ghouse.memoirist.dto.SectionDetails;
import com.ghouse.memoirist.entity.Section;
import static com.ghouse.memoirist.util.GenericUtil.TITLE_CHARACTER_LIMIT;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface SectionMapper {



	@Mapping(target = "sectionId", source = "section.sectionId")
	@Mapping(target = "sectionTitleDesc", source = "section.sectionName")
	@Mapping(target = "sectionTitle", source = "section.sectionName",qualifiedByName = "convertToTitle")
	@BeanMapping(ignoreByDefault = false)
	SectionDetails toSectionDetails(Section section);
	
	@Named("convertToTitle")
	public static String convertToTitle(String sectionName) {
		if(sectionName == null){
			return null;
		}
		return sectionName.substring(0, TITLE_CHARACTER_LIMIT)+"...";
	}
}