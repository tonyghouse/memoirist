package com.ghouse.memoirist.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Content {

	@Id
//	@GeneratedValue(generator="content-uuid")
//	@GenericGenerator(name="content-uuid", strategy = "uuid")
	private String contentId;

	private String contentType;

	@Convert(converter = JsonCustomConverter.class)
	@Column(columnDefinition = "jsonb")
	private JsonNode data;

	private String sectionId;
}
