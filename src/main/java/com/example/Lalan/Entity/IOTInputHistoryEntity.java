package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "iot_input_history")
public class IOTInputHistoryEntity {
    @Id
    private String iotInputHisId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iotInputDbHisId;
    private String deviceIdInIotInputHis;//foreign key
    private String parameterIdInIotInputHis;//foreign key
    private String parameterNameInIotInputHis;
    private String timeDateInIotInputHis;
}
