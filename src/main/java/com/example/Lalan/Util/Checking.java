package com.example.Lalan.Util;

import com.example.Lalan.DTO.ParameterRegistrationDTO;

public class Checking {
    ParameterRegistrationDTO parameterRegistrationDTO = new ParameterRegistrationDTO();
    private static void checkingCountOfChatacters(String userInputId){
        int count = 0;
        for (int i = 0; i < userInputId.length() ; i++) {
            if (userInputId.charAt(i)!=' ')
                count++;
        }
        System.out.println(count);
    }
}
