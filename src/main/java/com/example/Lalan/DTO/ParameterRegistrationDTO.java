package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ParameterRegistrationDTO {
//user should add parameter using 4 characters and that characters cannot be duplicate (this is for parameterId)
    private String parameterId;
    private String measuringUnit;
    private String dateTime;
    private String minValue;
    private String maxValue;
    private String parameterType;
    private String description;
    private String outOfRangeValueMessage;
    //when the registering the parameter details, user has to add how many error attempt need to pop up the error message on the user dashboard..
    private String numberOfAttemptsNeed;
    private String message;
    private Boolean isItStarterValue;
    private String alarmAlertType;
    private String requestParameterType;
    private String requestTime;
    private String userId_para;
    private String completedProdCount;

}
