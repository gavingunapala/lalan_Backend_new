package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "process_Config")
public class ProcessEntity {

    @Id
    private String  productID_proConf;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proConf_id;
    private String  parameterRange_proConf;
    private String processDateConf;
    private String processTimeConf;
}
