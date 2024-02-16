package com.ghouse.memoirist.service;

import com.ghouse.memoirist.dto.ProfileRS;
import com.ghouse.memoirist.entity.Profile;
import com.ghouse.memoirist.mapper.ProfileMapper;
import com.ghouse.memoirist.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ProfileMapper profileMapper;

    //TODO
    @Override
    public List<String> getProfilePermissions(String userName) {
//        Optional<Profile> profile = profileRepo.findById(userName);
//
//        if(profile.isPresent()){
//            return profile.get().getRoles();
//        }
        return Collections.emptyList();
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepo.save(profile);
    }

	@Override
	public ProfileRS getProfile(String userName) {
		Optional<Profile> profile = profileRepo.findById(userName);
		if(profile.isPresent()) {
			return profileMapper.toProfileRS(profile.get());
		}
		return null;
	}
}
