package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class IOTInputTransactionDTO {
    private String iotInputTraId;
    private String deviceIdInIotInputTra;//foreign key
    private String parameterIdInIotInputTra;//foreign key
    private String parameterNameInIotInputTra;
    private String timeDateInIotInputTra;
}
