package com.ghouse.memoirist.service;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<String> getProfilePermissions(String userName);

    Profile addProfile(Profile profile);

	ProfileRS getProfile(String userName);
}
