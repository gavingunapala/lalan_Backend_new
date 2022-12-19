package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "status")
public class StatusEntity {

    @Id
    private String  statusID_st;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int     st_ID;
    private String  status_st;
    private String  productID_st;


}
