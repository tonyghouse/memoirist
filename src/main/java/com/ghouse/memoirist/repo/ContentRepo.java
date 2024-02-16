package com.ghouse.memoirist.repo;

import com.ghouse.memoirist.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepo extends JpaRepository<Content,String> {

	List<Content> getBySectionId(String sectionId);

	List<Content> getByContentIdIn(List<String> contentsOrder);

}
