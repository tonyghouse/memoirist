package com.ghouse.memoirist.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProfileRS {

//	@JsonProperty("profileName")
	private String userName;

	private String firstName;

//	@JsonIgnore
	private String lastName;

	private String email;




}
