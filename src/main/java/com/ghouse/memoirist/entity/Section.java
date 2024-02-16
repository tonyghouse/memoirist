package com.ghouse.memoirist.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.ghouse.memoirist.config.JsonCustomConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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
