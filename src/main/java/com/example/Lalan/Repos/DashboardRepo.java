package com.example.Lalan.Repos;


import com.example.Lalan.Entity.DashboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DashboardRepo extends JpaRepository<DashboardEntity, String> {

//    public static final String sqldquery = "call db_20221223.sp_GetDataByDate('?1')" ;
//    @Query(value = sqldquery, nativeQuery = true)
//    public List<Object[]> getallbashboarddetails(Date predicted_date);



}
