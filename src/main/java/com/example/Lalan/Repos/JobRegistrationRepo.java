package com.example.Lalan.Repos;

import com.example.Lalan.Entity.JobRegistrationEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface JobRegistrationRepo extends JpaRepository<JobRegistrationEntity, String> {




//    @Query(value = "select * from lal_db.job_reg j where job_id = ?1", nativeQuery = true)
//    public List<JobRegistrationEntity> getalljobids(String job_id);
}
