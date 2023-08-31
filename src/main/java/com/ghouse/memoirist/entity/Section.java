package com.ghouse.memoirist.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.ghouse.memoirist.config.JsonCustomConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Section {

	@Id
	@GeneratedValue(generator = "section-uuid")
	@GenericGenerator(name = "section-uuid", strategy = "uuid")
	private String sectionId;

	private String sectionNameType;

	private LocalDate sectionDate;

	private String sectionName;
	
	@Convert(converter = JsonCustomConverter.class)
	@Column(columnDefinition = "jsonb")
	private JsonNode contentsOrder;


	private String userId;

}
