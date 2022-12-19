package com.example.Lalan.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

}
