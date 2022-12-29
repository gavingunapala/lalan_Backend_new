package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.apache.tomcat.jni.Time;
import org.springframework.format.annotation.DateTimeFormat;

// import java.sql.Date;

import java.util.Date;
import java.util.List;


@Entity
//@NamedStoredProcedureQuery(name = "lalan_tape_db.sp_GetJobID"
//        ,procedureName = "sp_GetJobID"
//        ,parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "in_job_id", type = String.class)
//        })
//
@NamedStoredProcedureQuery(name = "12232022db.sp_GetBatchID"
       ,procedureName = "sp_GetBatchID"
       ,parameters = {
       @StoredProcedureParameter(mode = ParameterMode.IN, name = "job_id_ad", type = String.class),
       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "out_batchid_ad", type = String.class)

})
//
// @NamedStoredProcedureQuery(name = "12232022db.sp_GetDataByDate"
//         ,procedureName = "sp_GetDataByDate"
//         ,parameters = {
//         @StoredProcedureParameter(mode = ParameterMode.IN, name = "predicted_date", type = Date.class),


// })
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin_control")

public class AdminEntity {


    @Id
    private  String adminid_ad;
    private  int admin_id;
    private  String batchid_ad;

    private String product_lineid_ad;
    private  String userid_ad;
    private  String job_id_ad;

    private Date production_start_datetime;
    private Date production_end_datetime;

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
