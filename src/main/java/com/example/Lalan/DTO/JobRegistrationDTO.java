package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class JobRegistrationDTO {

    private String jobId;
    private String jobName;
    private String jobDescription;
    private String product;
    private String count;
    private String userInJobId;
}
