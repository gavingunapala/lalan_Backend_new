package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(name = "lalan_tape_db.sp_GetJobID"
        ,procedureName = "sp_GetJobID"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "in_job_id", type = String.class)
        })
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admin_control")

public class AdminEntity {
    @Id
    private  String adminid_ad;
    private  int admin_id;
    private  String batchid_ad;
    private  String productLineod_ad;
    private  String userid_ad;
    private  String job_id_ad;
}
