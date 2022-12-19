package com.example.Lalan.Controller;

import com.example.Lalan.DTO.ParameterErrorMessageDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Services.ParameterErrorMessageService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/parameterErrorMessage")

public class ParameterErrorMessageController {
    @Autowired
    private ParameterErrorMessageService parameterErrorMessageService;

    @Autowired
    private ResponseDTO responseDTO;

    //---------------------------------------------------------------------------------------------------------
    //saving parameterErrorMessage details.....
    @PostMapping(value = "/saveParameterErrorMessage")
    public ResponseEntity saveParameterErrorMessage(@RequestBody ParameterErrorMessageDTO parameterErrorMessageDTO){
        try {
            String res=parameterErrorMessageService.saveParameterErrorMessage(parameterErrorMessageDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(parameterErrorMessageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Registered!");
                responseDTO.setContent(parameterErrorMessageDTO);
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
    //Updating parameterErrorMessage details...
    @PutMapping(value = "/updateRegisteredParameterErrorMessage/{parameterErrorMsgId}")
    public ResponseEntity   updateRegisteredParameterErrorMessage(@RequestBody ParameterErrorMessageDTO parameterErrorMessageDTO){
        try {
            String res=parameterErrorMessageService.updateRegisteredParameterErrorMessage(parameterErrorMessageDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(parameterErrorMessageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered User");
                responseDTO.setContent(parameterErrorMessageDTO);
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
    //Display registered parameterErrorMessages...
    @GetMapping("/getAllParameterErrorMessage")
    public ResponseEntity getAllParameterErrorMessage(){
        try {
            List<ParameterErrorMessageDTO> parameterErrorMessagesList = parameterErrorMessageService.getAllParameterErrorMessage();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success!");
            responseDTO.setContent(parameterErrorMessagesList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //--------------------------------------------------------------------------------------------------
    //Search parameterErrorMessage details using parameterId...
    @GetMapping("/searchRegisteredParameterErrorMessage/{parameterErrorMsgId}")
    public ResponseEntity searchRegisteredParameterErrorMessage(@PathVariable String parameterErrorMsgId){
        try {
            ParameterErrorMessageDTO parameterErrorMessageDTO = parameterErrorMessageService.searchRegisteredParameterErrorMessage(parameterErrorMsgId);
            if (parameterErrorMessageDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(parameterErrorMessageDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this parameterErrorMsgId");
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
    //Delete registered parameterErrorMessage...
    @DeleteMapping("/deleteRegisteredParameterErrorMessage/{parameterErrorMsgId}")
    public ResponseEntity deleteRegisteredParameterErrorMessage(@PathVariable String parameterErrorMsgId){
        try {
            String res = parameterErrorMessageService.deleteRegisteredParameterErrorMessage(parameterErrorMsgId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this parameterErrorMsgId");
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
