package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "pdm_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pdm_table")
public class ParameterDeviceMachineEntity {

  @Id
    private String paraId_PDM;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private String deviceID_PDM;
    private String machineId_PDM;

}
