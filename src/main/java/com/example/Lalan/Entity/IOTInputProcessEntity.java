package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "iot_input_process")

public class IOTInputProcessEntity {
    @Id
    private String iotInputId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iotInputDbId;
    private String deviceIdInIotInput;//foreign key
    private String parameterIdInIotInput;//foreign key
    private String parameterNameInIotInput;
    private String timeDateInIotInput;
}
