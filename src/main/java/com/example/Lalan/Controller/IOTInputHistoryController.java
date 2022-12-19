package com.example.Lalan.Controller;

import com.example.Lalan.DTO.IOTInputHistoryDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Entity.IOTInputHistoryEntity;
import com.example.Lalan.Services.IOTInputHistoryService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/IOTInputHistory")

public class IOTInputHistoryController {
    @Autowired
    private IOTInputHistoryService iotInputHistoryService;

    @Autowired
    private ResponseDTO responseDTO;
    //---------------------------------------------------------------------------------------------------------
    //saving IOTInputHistory details.....
    @PostMapping(value = "/SaveIOTInputHistory")
    public ResponseEntity SaveIOTInputHistory(@RequestBody IOTInputHistoryDTO iotInputHistoryDTO){
        try {
            String res=iotInputHistoryService.SaveIOTInputHistory(iotInputHistoryDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully recorded!");
                responseDTO.setContent(iotInputHistoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Registered!");
                responseDTO.setContent(iotInputHistoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error!");
                responseDTO.setContent(null);//employeeDTO
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //---------------------------------------------------------------------------------------------------------
    //Updating IOTInputHistory details...
    @PutMapping(value = "/updateRegisteredIOTInputHistory/{iotInputHisId}")
    public ResponseEntity   updateRegisteredIOTInputHistory(@RequestBody IOTInputHistoryDTO iotInputHistoryDTO){
        try {
            String res=iotInputHistoryService.updateRegisteredIOTInputHistory(iotInputHistoryDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully updated IOTInputHistory!");
                responseDTO.setContent(iotInputHistoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered IOTInputHistory");
                responseDTO.setContent(iotInputHistoryDTO);
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
    //Display registered IOTInputHistory...
    @GetMapping("/getAllIOTInputHistory")
    public ResponseEntity getAllIOTInputHistory(){
        try {
            List<IOTInputHistoryDTO> iotInputHistoryList = iotInputHistoryService.getAllIOTInputHistory();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success!");
            responseDTO.setContent(iotInputHistoryList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //--------------------------------------------------------------------------------------------------
    //Search user details using IOTInputHistory...
    @GetMapping("/searchRegisteredIOTInputHistory/{iotInputHisId}")
    public ResponseEntity searchRegisteredIOTInputHistory(@PathVariable String iotInputHisId){
        try {
            IOTInputHistoryDTO iotInputHistoryDTO = iotInputHistoryService.searchRegisteredIOTInputHistory(iotInputHisId);
            if (iotInputHistoryDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(iotInputHistoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this iotInputHisId");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered IOTInputHistory...
    @DeleteMapping("/deleteRegisteredIOTInputHistory/{userId}")
    public ResponseEntity deleteRegisteredIOTInputHistory(@PathVariable String iotInputHisId){
        try {
            String res = iotInputHistoryService.deleteRegisteredIOTInputHistory(iotInputHisId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this iotInputHisId");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
