package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

import com.example.Lalan.Entity.LineRegistrationEntity;
import org.apache.tomcat.jni.Time;

// import javax.persistence.OneToMany;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {


    // @OneToMany(mappedBy = "LineRegistrationDTO")
    // private List<LineRegistrationDTO>LineRegistration;


    private  String adminid_ad;
    private  int admin_id;
    private  String batchid_ad;

    private String product_lineid_ad;
    private  String userid_ad;
    private  String job_id_ad;

    private String production_start_datetime;
    private String production_end_datetime;

    private int customer_id;
    private String customer_name;

    private String product_id;
    private String product_name;
    private int count_reg_bch;

    private String machine_id;
    private String machine_name;
    private String device_id;

    private String device_name_dvc_reg;
    private String batch_start_time;
    private String batch_end_time;

    private Date predicted_date;

    private int production_order;



}