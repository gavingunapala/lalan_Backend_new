package com.example.Lalan.Repos;

import com.example.Lalan.DTO.MachineLineTestDTO;
import com.example.Lalan.Entity.MachineLineTestEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MachineLineTestRepo extends JpaRepository<MachineLineTestEntity, String> {

    @Query(value = "SELECT *  FROM lm_table l WHERE l.machine_lineid = ?1 ", nativeQuery = true)
    MachineLineTestEntity getMachineLineTestById(String machineLineID);


//    @Query(value = " SELECT machineid  FROM lal_db.lm_table", nativeQuery = true)

//    List <MachineLineTestEntity> getallMachineLineTest();
    @Query(value = "select * from lm_table m where m.machine_lineid = 'ML1'", nativeQuery = true)
    List <MachineLineTestEntity> getallmachine();

//    @Query(value = "select m from lm_table m where m.machine_lineid = 'ML1'", nativeQuery = true)
//    List <MachineLineTestEntity> getallmachinebyid(@Param("machine_lineid") String machine_lineid);

}
