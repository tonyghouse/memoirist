package com.ghouse.memoirist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghouse.memoirist.entity.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,String> {

}
