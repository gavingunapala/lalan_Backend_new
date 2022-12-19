package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Status_Output")
public class StatusOutputEntity {

    @Id
    private String StatusOutputID;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StOut_ID;
    private String  ColorCode_StOut;
    private String  ColorName_StOut;
}
