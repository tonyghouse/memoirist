package com.ghouse.memoirist.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter(autoApply = true)
public class JsonCustomConverter implements AttributeConverter<JsonNode, String> {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(JsonNode node) {
		if(node == null) {
			return "{}";
		}
		return node.toString();
	}

	@Override
	public JsonNode convertToEntityAttribute(String data) {
		try {
			return objectMapper.readTree(data);
		} catch (Exception exp) {
			return null;
		}
	}
}