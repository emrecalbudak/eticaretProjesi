package com.spring.project.core.dataAccess;

import com.spring.project.core.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    boolean existsByEmail(@Email @NotBlank @NotNull String email);
}
