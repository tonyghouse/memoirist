package com.ghouse.memoirist.mapper;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

////	@Mapping(target = "userName", source = "profile.userName")
//	@Mapping(target = "email", source = "profile.email")
	@BeanMapping(ignoreByDefault = false)
	ProfileRS toProfileRS(Profile profile);

}