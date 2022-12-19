package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IOTInputHistoryDTO {
    private String iotInputHisId;
    private String deviceIdInIotInputHis;//foreign key
    private String parameterIdInIotInputHis;//foreign key
    private String parameterNameInIotInputHis;
    private String timeDateInIotInputHis;
}
