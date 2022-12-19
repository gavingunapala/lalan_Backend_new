package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "lm_table")
public class MachineLineTestEntity {
    

    private String machineLineID;
    @Id
    private String machineID;
    
}
