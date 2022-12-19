package com.example.Lalan.Repos;

import com.example.Lalan.Entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<StatusEntity, String> {
}
