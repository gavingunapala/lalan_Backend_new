package com.example.Lalan.Controller;

import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.UserRegistrationService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")

public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegisterService;
    @Autowired
    private ResponseDTO responseDTO;
    //---------------------------------------------------------------------------------------------------------
    //saving user details.....
    @PostMapping(value = "/saveUser")
    public ResponseEntity saveUser(@RequestBody UserRegistrationDTO userRegisterDTO){
        try {
            String res=userRegisterService.saveUser(userRegisterDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(userRegisterDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Registered!");
                responseDTO.setContent(userRegisterDTO);
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
    //Updating user details...
    @PutMapping(value = "/updateRegisteredUser/{userId}")
    public ResponseEntity   updateRegisteredUser(@RequestBody UserRegistrationDTO userRegisterDTO){
        try {
            String res=userRegisterService.updateRegisteredUser(userRegisterDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(userRegisterDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered User");
                responseDTO.setContent(userRegisterDTO);
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
    //Display registered users...
    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(){
        try {
            List<UserRegistrationDTO> userList = userRegisterService.getAllUsers();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success!");
            responseDTO.setContent(userList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //--------------------------------------------------------------------------------------------------
    //Search user details using userId...
    @GetMapping("/searchRegisteredUser/{userId}")
    public ResponseEntity searchRegisteredUser(@PathVariable String userId){
        try {
            UserRegistrationDTO userRegistrationDTO = userRegisterService.searchRegisteredUser(userId);
            if (userRegistrationDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(userRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this userId");
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
    //Delete registered user...
    @DeleteMapping("/deleteRegisteredUser/{userId}")
    public ResponseEntity deleteRegisteredUser(@PathVariable String userId){
        try {
            String res = userRegisterService.deleteRegisteredUser(userId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this userId");
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
