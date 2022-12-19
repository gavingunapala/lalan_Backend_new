package com.example.Lalan.Repos;

import com.example.Lalan.Entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LogEntity, String> {
}
