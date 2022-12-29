package com.example.Lalan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerRegistrationDTO {

    private String cus_id;
    private String customer_name;
    private String customer_NIC;
    private String customer_contact_number;
    private String customer_email;
    private String contact_person;
}
