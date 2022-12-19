package com.example.Lalan.Entity;

import com.example.Lalan.Util.CategoryBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "batch_Reg")
public class BatchEntity {

    @Id
    private String  batchID_regBch;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bch_id;
    private int  count_regBch;
    private String  batchName_regBch;
    private String userID_regBch;
    private String productCategory;

    //foreign key to  admin_Control table: batchID_regBch --> batchID_ad
    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="batchID_ad",referencedColumnName = "batchID_regBch")
    private List<AdminEntity> adminEntityList;

   /* //foreign key to  admin_Control table: batchID_regBch --> batchID_ad
    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="batchID_ad",referencedColumnName = "batchID_regBch")
    private List<AdminEntity> adminEntityList;*/
}
