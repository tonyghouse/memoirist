package com.ghouse.memoirist.service;

import java.util.List;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;

public interface ProfileService {
    List<String> getProfilePermissions(String userName);

    Profile addProfile(Profile profile);

	ProfileRS getProfile(String userName);
}
