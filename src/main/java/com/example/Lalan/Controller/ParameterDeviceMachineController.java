package com.example.Lalan.Controller;


import com.example.Lalan.DTO.ParameterDeviceMachineDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import com.example.Lalan.Services.ParameterDeviceMachineService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/PDM")
public class ParameterDeviceMachineController {

    @Autowired
    private ParameterDeviceMachineService parameterDeviceMachineService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/savePDM")
    public ResponseEntity savePDM(@RequestBody ParameterDeviceMachineDTO parameterDeviceMachineDTO){

        try{
            String res = parameterDeviceMachineService.savePDM(parameterDeviceMachineDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully registered!");
                responseDTO.setContent(parameterDeviceMachineDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered");
                responseDTO.setContent(parameterDeviceMachineDTO);
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
    //update the existing batch
    @PutMapping(value = "/updatePDM/{paraId_PDM}")
    public ResponseEntity updatePDM(@RequestBody ParameterDeviceMachineDTO parameterDeviceMachineDTO){

        try{
            String res = parameterDeviceMachineService.updatePDM(parameterDeviceMachineDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success!");
                responseDTO.setContent(parameterDeviceMachineDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered state not found!");
                responseDTO.setContent(parameterDeviceMachineDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error Occurred!");
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
    @GetMapping("/getAllPDM")
    public ResponseEntity getAllPDM(){
        try {
            List<ParameterDeviceMachineDTO> PDMList = parameterDeviceMachineService.getAllPDM();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success!");
            responseDTO.setContent(PDMList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/searchPDM/{paraId_PDM}")
    public ResponseEntity searchPDM(@PathVariable String paraId_PDM){
        try {
            ParameterDeviceMachineDTO parameterDeviceMachineDTO = parameterDeviceMachineService.searchPDM(paraId_PDM);
            if (parameterDeviceMachineDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(paraId_PDM);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No batch Available For this product ID");
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
    @DeleteMapping("/deletePDM/{paraId_PDM}")
    public ResponseEntity deletePDM(@PathVariable String paraId_PDM){
        try {
            String res = parameterDeviceMachineService.deletePDM(paraId_PDM);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Batch Available For this product id");
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


    @GetMapping("/getalltestsdevices")
    public List <ParameterDeviceMachineEntity> getall(){
        return  parameterDeviceMachineService.getall();
    }

    @GetMapping("/getalltestsparameters")
    public List <ParameterDeviceMachineEntity> getallparas(){
        return  parameterDeviceMachineService.getallparas();
    }

    @GetMapping("/getDetailsfrmMachineID/{MID}")
    public ResponseEntity<List<ParameterDeviceMachineEntity>> getDetailsFromMachineID(@PathVariable String MID){
        return new ResponseEntity <> (parameterDeviceMachineService.getMachineDetailsFmId(MID),HttpStatus.OK);
    }
}


