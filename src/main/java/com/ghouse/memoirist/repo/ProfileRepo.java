package com.ghouse.memoirist.repo;

import com.ghouse.memoirist.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,String> {

}
