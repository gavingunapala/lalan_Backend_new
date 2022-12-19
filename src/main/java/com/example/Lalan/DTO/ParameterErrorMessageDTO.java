package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParameterErrorMessageDTO {
    private String parameterErrorMsgId;
    private String errorMsgDescription;
}
