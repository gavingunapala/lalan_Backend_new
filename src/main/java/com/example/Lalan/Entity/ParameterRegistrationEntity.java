package com.example.Lalan.Entity;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "parameter_reg")

public class ParameterRegistrationEntity {

    @Id
    private String parameterId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paraDbId;
    private String measuringUnit;
    private String dateTime;
    private String minValue;
    private String maxValue;
    private String completedProdCount;

    @NotNull
    @Column(length = 500)

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


   //foreign key to  iot_input table: parameterID --> parameterIdInIotInput
//    @OneToMany(targetEntity = IOTInputProcessEntity.class, cascade = CascadeType.ALL)
//    @JoinColumn(name ="parameterIdInIotInput",referencedColumnName = "parameterId")
//    private List<IOTInputProcessEntity> IOTInputEntityList;

    //foreign key to  admin_Control table: parameterId --> parameterID_ad
//    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
//    @JoinColumn(name ="parameterID_ad",referencedColumnName = "parameterId")
//    private List<AdminEntity> adminEntityList;

}
