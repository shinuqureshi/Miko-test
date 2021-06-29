package com.miko.test.miko.Repository;

import com.miko.test.miko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User ,Integer> {


    Optional<User>findUserByEmail(String email);
}
