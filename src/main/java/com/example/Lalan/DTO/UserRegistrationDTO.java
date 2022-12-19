package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserRegistrationDTO {

    // private int cusId;
    private String userId;
    private String userName;
    private String userNIC;
    private String userEmail;
    private String userContactNumber;
    private String userRole;
    private String userPosition;
    private String userPassword;
}
