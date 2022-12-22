package com.example.Lalan.Repos;

import com.example.Lalan.Entity.AdminEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.Map;

public interface AdminRepo extends JpaRepository<AdminEntity, String> {


//    @Procedure(name = "lalan_tape_db.sp_GetJobID")
//    public Map<String, Object> getalljobidsbyprocedure(String job_id_ad);

    public static final String sqlquery = "call lalan_tape_db.sp_GetJobID()" ;
    @Query(value = sqlquery, nativeQuery = true)
    public List<Object[]> getalljobidsbyprocedure();

}
