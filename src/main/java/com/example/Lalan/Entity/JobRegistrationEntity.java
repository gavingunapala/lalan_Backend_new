package com.example.Lalan.Entity;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "job_reg")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "job_reg")

public class JobRegistrationEntity {
    @Id
    private String jobId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobDbId;
    private String jobName;

    @NotNull
    @Column(length = 500)
    private String jobDescription;
    private String product;
    private String count;
    private String userInJobId;//this is from job_reg table (foreign key)


    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="job_id_ad",referencedColumnName = "jobId")
    private List<AdminEntity> adminEntityList;

}
