package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class LineRegistrationDTO {

    private String lineId;
    private String lineName;
    private String description;
    private String image;
    private String startTime;
    private String endTime;
    private String userID_line;

}
