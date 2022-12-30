package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "dashboard_test")


public class DashboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auto_id;
    private String job_id_ad;
    private int customer_id;
    private String customer_name;
    private String batchid_ad;
    private String product_id;
    private String product_name;
    private int count_reg_bch;
    private String product_lineid_ad;
    private String machine_id;
    private String machine_name;
    private String device_id;

    private String device_name_dvc_reg;
    private Time batch_start_time;
    private Time batch_end_time;
    private Date predicted_date;

    private int production_order;



}
