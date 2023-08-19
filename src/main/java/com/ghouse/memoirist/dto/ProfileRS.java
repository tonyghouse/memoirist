package com.ghouse.memoirist.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
