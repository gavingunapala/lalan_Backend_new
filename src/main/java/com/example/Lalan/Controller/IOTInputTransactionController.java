package com.example.Lalan.Controller;

import com.example.Lalan.DTO.IOTInputTransactionDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Services.IOTInputTransactionService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/IOTInputTransaction")
public class IOTInputTransactionController {
    @Autowired
    private IOTInputTransactionService iotInputTransactionService;

    @Autowired
    private ResponseDTO responseDTO;

    //---------------------------------------------------------------------------------------------------------
    //Updating IOTInputTransaction details...
    @PutMapping(value = "/updateRegisteredIOTInputTransaction/{iotInputTraId}")
    public ResponseEntity updateRegisteredIOTInputTransaction(@RequestBody IOTInputTransactionDTO iotInputTransactionDTO){
        try {
            String res=iotInputTransactionService.updateRegisteredIOTInputTransaction(iotInputTransactionDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully updated!");
                responseDTO.setContent(iotInputTransactionDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered data");
                responseDTO.setContent(iotInputTransactionDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //-----------------------------------------------------------------------------------------------------
    //Display registered IOTInputTransaction...
    @GetMapping("/getAllIOTInputTransactional")
    public ResponseEntity getAllIOTInputTransactional(){
        try {
            List<IOTInputTransactionDTO> iotInputTransactionList = iotInputTransactionService.getAllIOTInputTransactional();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success!");
            responseDTO.setContent(iotInputTransactionList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
