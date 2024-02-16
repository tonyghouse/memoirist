package com.ghouse.memoirist.repo;

import com.ghouse.memoirist.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SectionRepo extends JpaRepository<Section,String> {

	@Query("SELECT section FROM Section section WHERE sectionNameType =:sectionNameType AND userId =:userId ")
	Page<Section> getTopSections(String userId, String sectionNameType, Pageable pageable);

	Section getBySectionDate(LocalDate sectionDate);

	Section getBySectionId(String sectionId);

	List<Section> getBySectionDateIn(List<LocalDate> sectionDates);

    List<Section> getBySectionDateAndUserId(LocalDate parsedSectionDate, String userId);
}
