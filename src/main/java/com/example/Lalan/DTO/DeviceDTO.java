package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceDTO {

    //private int dvc_id;
    private String  deviceID_dvcReg;
    private String  deviceName_dvcReg;
    private String  parameterType_dvcReg;
    //private String  ProductLineDvcReg;
    private String lineDvcReg;
    private String deviceGPSLocation;
    private String deviceIpAddress;
}
