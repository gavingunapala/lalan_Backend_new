package com.example.Lalan.Repos;

import com.example.Lalan.Entity.UserRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepo extends JpaRepository<UserRegistrationEntity, String> {
}
