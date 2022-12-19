package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StatusOutputDTO {
    //private String  StatusOutputID_StOut;
    private String StatusOutputID;
    private String  ColorCode_StOut;
    private String  ColorName_StOut;

}
