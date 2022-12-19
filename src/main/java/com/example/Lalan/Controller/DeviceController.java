package com.example.Lalan.Controller;


import com.example.Lalan.DTO.DeviceDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.DeviceService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController{

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/saveDevice")
    public ResponseEntity saveDevice(@RequestBody DeviceDTO deviceDTO){

        try{
            String res = deviceService.saveDevice(deviceDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully Registered");
                responseDTO.setContent(deviceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already Registered");
                responseDTO.setContent(deviceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error Occurred");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    //update the existing device
    @PutMapping(value = "/updateDevice/{deviceID_dvcReg}")
    public ResponseEntity updateProduct(@RequestBody DeviceDTO deviceDTO){

        try{
            String res = deviceService.updateDevice(deviceDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(deviceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered state not found");
                responseDTO.setContent(deviceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error Occurred");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }catch(Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/getAllDevice")
    public ResponseEntity getAllDevice(){
        try {
            List<DeviceDTO> deviceDTOList = deviceService.getAllDevice();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success");
            responseDTO.setContent(deviceDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/searchDevice/{deviceID_dvcReg}")
    public ResponseEntity searchDevice(@PathVariable String deviceID_dvcReg){
        try {
            DeviceDTO deviceDTO = deviceService.searchDevice(deviceID_dvcReg);
            if (deviceDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(deviceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No product Available For this product ID");
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

    @DeleteMapping("/deleteDevice/{deviceID_dvcReg}")
    public ResponseEntity deleteDevice(@PathVariable String deviceID_dvcReg){
        try {
            String res = deviceService.deleteDevice(deviceID_dvcReg);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Product Available For this product id");
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
