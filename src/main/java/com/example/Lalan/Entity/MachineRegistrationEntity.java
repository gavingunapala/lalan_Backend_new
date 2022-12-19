package com.example.Lalan.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "machine_reg")

public class MachineRegistrationEntity {

    @Id
    private String machineId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int machDbId;

    @NotNull
    @Column(length = 500)
    private String machineDescription;
    private String machineName;
    private String machineImage;
    private String dateTime;
    private String machineID_machi;

   //foreign key to  admin_Control table: machineId --> machineID_ad
    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="machineID_ad",referencedColumnName = "machineId")
    private List<AdminEntity> adminEntityList;
}
