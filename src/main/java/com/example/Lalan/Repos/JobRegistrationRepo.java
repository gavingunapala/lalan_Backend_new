package com.example.Lalan.Repos;

import com.example.Lalan.Entity.JobRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRegistrationRepo extends JpaRepository<JobRegistrationEntity, String> {
}
