package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_reg")

public class UserRegistrationEntity {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userDbId;
    private String userName;
    private String userNIC;
    private String userEmail;
    private String userContactNumber;
    private String userRole;
    private String userPosition;
    private String userPassword;

    // //foreign key to  admin_Control table: userId --> userID_ad
    // @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userID_ad",referencedColumnName = "userId")
    // private List<AdminEntity> adminEntityList;

    // //foreign key to  batch_Reg table: userId --> userID_regBch
    // @OneToMany(targetEntity = BatchEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userID_regBch",referencedColumnName = "userId")
    // private List<BatchEntity> batchEntityList;

    //foreign key to  job_reg table: userId --> userInJobId
    // @OneToMany(targetEntity = JobRegistrationEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userInJobId",referencedColumnName = "userId")
    // private List<JobRegistrationEntity> jobRegistrationEntityList;

    // //foreign key to  line_reg table: userId --> userID_line
    // @OneToMany(targetEntity = LineRegistrationEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userID_line",referencedColumnName = "userId")
    // private List<LineRegistrationEntity> lineEntityList;

    // //foreign key to  machine_reg table: userId --> machineID_machi
    // @OneToMany(targetEntity = MachineRegistrationEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="machineID_machi",referencedColumnName = "userId")
    // private List<MachineRegistrationEntity> machineRegistrationEntityList;

    // //foreign key to  machine_reg table: userId --> userId_para
    // @OneToMany(targetEntity = MachineRegistrationEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userId_para",referencedColumnName = "userId")
    // private List<MachineRegistrationEntity> parameterRegistrationEntityList;

    // //foreign key to  product_Reg table: userId --> userID_pro
    // @OneToMany(targetEntity = ProductRegistrationEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="userID_pro",referencedColumnName = "userId")
    // private List<ProductRegistrationEntity> productRegistrationEntityList;
}
