package com.ghouse.memoirist.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.ghouse.memoirist.config.JsonCustomConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Template {

	@Id
	@GeneratedValue(generator = "template-uuid")
	@GenericGenerator(name = "template-uuid", strategy = "uuid")
	private String templateId;
	
	private String templateName;
	
	private String author;

	@Convert(converter = JsonCustomConverter.class)
	@Column(columnDefinition = "jsonb")
	private JsonNode contentsOrder;

}
