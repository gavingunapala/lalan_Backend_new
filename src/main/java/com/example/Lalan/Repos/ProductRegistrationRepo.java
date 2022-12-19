package com.example.Lalan.Repos;

import com.example.Lalan.Entity.ProductRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRegistrationRepo extends JpaRepository<ProductRegistrationEntity, String> {
}
