package com.emrealkan.restapiforkotlin.repository;

import com.emrealkan.restapiforkotlin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);


}
