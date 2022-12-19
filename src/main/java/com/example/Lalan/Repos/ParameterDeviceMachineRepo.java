package com.example.Lalan.Repos;

import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParameterDeviceMachineRepo extends JpaRepository<ParameterDeviceMachineEntity, String> {
    @Query(value = "select * from pdm_table d where d.machine_id_pdm = 'm1'", nativeQuery = true)
    List<ParameterDeviceMachineEntity> getalldevices();


    @Query(value = "select *  from pdm_table p ", nativeQuery = true)
    List<ParameterDeviceMachineEntity> getallparameters();
}
