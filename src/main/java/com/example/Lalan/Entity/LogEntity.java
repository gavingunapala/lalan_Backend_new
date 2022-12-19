package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_log")
public class LogEntity {
    @Id
    private String  logID_lg;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int log_id;
    private String  customerID_lg;
    private String  task_lg;
    private String  date_lg;
    private String  time_lg;
}
