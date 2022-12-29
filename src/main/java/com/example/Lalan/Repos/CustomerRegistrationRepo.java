package com.example.Lalan.Repos;


import com.example.Lalan.Entity.CustomerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRegistrationRepo extends JpaRepository<CustomerRegistrationEntity, String> {
}
