package com.example.Lalan.Repos;

import com.example.Lalan.Entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<DeviceEntity, String> {
}
