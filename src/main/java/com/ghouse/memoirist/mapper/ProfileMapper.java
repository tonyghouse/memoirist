package com.ghouse.memoirist.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

////	@Mapping(target = "userName", source = "profile.userName")
//	@Mapping(target = "email", source = "profile.email")
	@BeanMapping(ignoreByDefault = false)
	ProfileRS toProfileRS(Profile profile);

}