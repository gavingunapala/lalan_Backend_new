package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class IOTInputProcessDTO {
    private String iotInputId;
    private String deviceIdInIotInput;//foreign key
    private String parameterIdInIotInput;//foreign key
    private String parameterNameInIotInput;
    private String timeDateInIotInput;
}
