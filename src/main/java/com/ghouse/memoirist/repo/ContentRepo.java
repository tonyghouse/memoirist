package com.ghouse.memoirist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghouse.memoirist.entity.Content;

@Repository
public interface ContentRepo extends JpaRepository<Content,String> {

	List<Content> getBySectionId(String sectionId);

	List<Content> getByContentIdIn(List<String> contentsOrder);

}
