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

@NamedStoredProcedureQuery(name = "db_20221223.sp_GetDataByDate"
        ,procedureName = "sp_GetDataByDate"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "predicted_date", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "job_id_ad", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "customer_id", type = int.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "customer_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "batchid_ad", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "product_id", type = String.class),

        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "product_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_reg_bch", type = int.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "product_lineid_ad", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "machine_name", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "device_id", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "device_name_dvc_reg", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "batch_start_time", type = Time.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "batch_end_time", type = Time.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "predicted_date", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "production_order", type = int.class),


})
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
