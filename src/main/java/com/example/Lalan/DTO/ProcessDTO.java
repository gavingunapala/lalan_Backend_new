package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProcessDTO {

    private String  productID_proConf;
    private String  parameterRange_proConf;
    /*private String  Date_proConf;
    private String  Time_proConf;*/
    private String processDateConf;
    private String processTimeConf;
}
