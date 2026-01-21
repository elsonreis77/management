package com.elsonreis.management.repository;

import com.elsonreis.management.entity.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
