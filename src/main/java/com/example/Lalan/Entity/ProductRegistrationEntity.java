package com.example.Lalan.Entity;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_Reg")
public class ProductRegistrationEntity {

    @Id
    private String productId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proDbId;
    private String productName;

    @NotNull
    @Column(length = 500)
    private String description;
    private String image;
    private String dateAndTime;
    private String userID_pro;


    //foreign key to  status table: productId --> productID_st
    @OneToMany(targetEntity = StatusEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="productID_st",referencedColumnName = "productId")
    private List<StatusEntity> statusEntityList;

    //foreign key to  admin_Control table: productId --> productID_ad
//    @OneToMany(targetEntity = AdminEntity.class, cascade = CascadeType.ALL)
//    @JoinColumn(name ="productID_ad",referencedColumnName = "productId")
//    private List<AdminEntity> adminEntityList;

}
