package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "iot_input_transaction")
public class IOTInputTransactionEntity {
    @Id
    private String iotInputTraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iotInputDbTraId;
    private String deviceIdInIotInputTra;//foreign key
    private String parameterIdInIotInputTra;//foreign key
    private String parameterNameInIotInputTra;
    private String timeDateInIotInputTra;
}
