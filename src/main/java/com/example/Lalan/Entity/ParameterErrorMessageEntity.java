package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "parameter_error_message")
public class ParameterErrorMessageEntity {
    @Id
    private String parameterErrorMsgId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String errorMsgDescription;
}
