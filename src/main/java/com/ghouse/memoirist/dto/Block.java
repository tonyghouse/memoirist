package com.ghouse.memoirist.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Block {
	private String id;
	private String type;
	private JsonNode data;

}
