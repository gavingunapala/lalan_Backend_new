package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRegistrationDTO {

    private String productId;
    private String productName;
    private String description;
    private String image;
    private String dateAndTime;
    private String userID_pro;
}
