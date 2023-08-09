package com.ghouse.memoirist.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Profile {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

}
