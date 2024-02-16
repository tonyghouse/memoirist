package com.ghouse.memoirist.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {

	@Id
    private String userId;
	
	private String userName;

}
