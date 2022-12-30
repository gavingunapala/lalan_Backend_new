package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "device_Reg")
public class DeviceEntity {

    @Id
    private String  deviceID_dvcReg;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dvc_id;
    private String  deviceName_dvcReg;
    private String  parameterType_dvcReg;
    //private String  ProductLineDvcReg;
    private String lineDvcReg;
    private String deviceGPSLocation;
    private String deviceIpAddress;

    //foreign key to  iot_input table: deviceID_dvcReg ---> deviceIdInIotInput
    // @OneToMany(targetEntity = IOTInputProcessEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="deviceIdInIotInput",referencedColumnName = "deviceID_dvcReg")
    // private List<IOTInputProcessEntity> IOTInputEntityList;

}
