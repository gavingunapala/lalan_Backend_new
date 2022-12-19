package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogDTO {
    private String  logID_lg;
    private String  customerID_lg;
    private String  task_lg;
    private String  date_lg;
    private String  time_lg;
}
