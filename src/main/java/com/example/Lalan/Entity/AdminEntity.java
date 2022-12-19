package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin_Control")
public class AdminEntity {

    @Id
    private String  adminID_ad;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     admin_id;
    private String  productID_ad;//foreign key
    private String  batchID_ad;
    private String  productLineID_ad;
    private String  machineID_ad;
    private String  parameterID_ad;
    private String userID_ad;
}
