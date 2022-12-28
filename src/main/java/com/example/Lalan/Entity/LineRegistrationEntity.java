package com.example.Lalan.Entity;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "line_reg")

public class LineRegistrationEntity {
    @Id
    private String lineId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lineDbId;
    private String lineName;

    @NotNull
    @Column(length = 500)
    private String description;
    private String image;
    private String startTime;
    private String endTime;
    private String userID_line;//foreign key

    // //foreign key to  admin_Control table: lineId --> productLineID_ad
    // @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    // @JoinColumn(name ="productLineID_ad",referencedColumnName = "lineId")
    // private List<AdminEntity> adminEntityList;
    @OneToMany(mappedBy = "lineid")
    private List<AdminEntity>admincontrol;
}
