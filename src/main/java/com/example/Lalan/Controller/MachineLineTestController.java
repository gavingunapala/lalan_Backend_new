package com.example.Lalan.Controller;

import com.example.Lalan.DTO.MachineLineTestDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Repos.MachineLineTestRepo;
import com.example.Lalan.Services.MachineLineTestService;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/MachineLineTest")
public class MachineLineTestController {
    @Autowired
    private MachineLineTestService machineLineTestService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/saveMachineLineTest")
    public ResponseEntity saveMachineLineTest(@RequestBody MachineLineTestDTO machineLineTestDTO){

        try{
            String res = machineLineTestService.saveMachineLineTest(machineLineTestDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(machineLineTestDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered");
                responseDTO.setContent(machineLineTestDTO);
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

    @GetMapping("/getAllMachineLineTest")
    public ResponseEntity getAllMachineLineTest(){
        try {
            List<MachineLineTestDTO> machineLineTestDTOList = machineLineTestService.getAllMachineLineTest();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success!");
            responseDTO.setContent(machineLineTestDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @GetMapping("/searchMachineLineTest/{machineLineID}")
    public ResponseEntity searchMachineLineTest(@PathVariable String machineLineID){
        try {
            MachineLineTestDTO machineLineTestDTO = machineLineTestService.searchMachineLineTest(machineLineID);
            if (machineLineTestDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(machineLineTestDTO);
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

    @GetMapping("/getMachineLineTestById/{machineLineID}")
    public MachineLineTestDTO getMachineLineTestById(@PathVariable String machineLineID){
    return machineLineTestService.getMachineLineTestById(machineLineID);
    }

    @GetMapping("/getalltests")
    public List <MachineLineTestEntity> getall(){

        return  machineLineTestService.getall();
    }

//    @GetMapping("/getalltestsbyid/{machine_lineid}")
//    public List<MachineLineTestEntity> findmachinebyid(@PathVariable String machine_lineid){
//        return machineLineTestService.getalltestsbyid(machine_lineid);
//    }

}
