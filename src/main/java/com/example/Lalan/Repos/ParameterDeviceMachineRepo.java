package com.example.Lalan.Repos;

import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParameterDeviceMachineRepo extends JpaRepository<ParameterDeviceMachineEntity, String> {
    @Query(value = "select * from pdm_table d where d.machine_id_pdm = 'm1'", nativeQuery = true)
    List<ParameterDeviceMachineEntity> getalldevices();


    @Query(value = "select *  from pdm_table p ", nativeQuery = true)
    List<ParameterDeviceMachineEntity> getallparameters();

//    @Query("select * from lal_db.pdm_table where machine_id_pdm = :machine_id_pdm_1 and deviceid_pdm = :deviceid_pdm_1")
//    List <ParameterDeviceMachineEntity> findparameters(@Param("machine_id_pdm_1") String machine_id_pdm_1,@Param("deviceid_pdm_1") String deviceid_pdm_1);

//    @Query(value = "SELECT * FROM pdm_table WHERE machine_id_pdm = ?1", nativeQuery = true)
//    ParameterDeviceMachineEntity getAlldataFromId(String machineID);
}
