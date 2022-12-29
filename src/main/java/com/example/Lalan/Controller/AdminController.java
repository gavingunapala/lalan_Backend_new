package com.example.Lalan.Controller;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;
import com.example.Lalan.Services.AdminService;

import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.springframework.format.annotation.DateTimeFormat;

// import java.text.SimpleDateFormat;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ResponseDTO responseDTO;

    // @GetMapping("/getalldata")
    // public List<Object[]> getalldata(){
    //
    // return adminService.getall();
    // }
    //
    //
    @GetMapping("/getallbatches/{job_id_ad}")
    public List<Object[]> getallbatchdata(@PathVariable String job_id_ad) {

        return adminService.getallbatches(job_id_ad);
    }

    // // test
    // @GetMapping("/getalldatawithdate/{Date}")
    // public List<Object[]> getallbatchdata(
    // @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date
    // Date11) {
    // return adminService.getalldata(Date11);
    // }

    @GetMapping("/getLineByDate/{Date}")
    public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11) {
        return adminService.getLineByDate(Date11);
    }

    // get Get Customer Details By Date And LineId
    @GetMapping("/GetDetailsByDateAndLineId/{Date}/{LineId}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId) {
        return adminService.GetDetailsByDateAndLineId(Date11, LineId);
    }

    // get Get machines By Date And LineId and pOrder
    @GetMapping("/GetDetailsByDateAndLineIdAndPOrder/{Date}/{LineId}/{pOrder}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId, @PathVariable int pOrder) {
        return adminService.GetDetailsByDateAndLineIdAndPOrder(Date11, LineId, pOrder);
    }

    // get Get Perameters By Date And LineId and pOrder and Machine Id
    @GetMapping("/GetDetailsByDateAndLineIdAndPOrder/{Date}/{LineId}/{pOrder}/{MachineId}")
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11,
            @PathVariable String LineId, @PathVariable int pOrder, @PathVariable String MachineId) {
        return adminService.GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date11, LineId, pOrder, MachineId);
    }

    // get values to the table
    @GetMapping("/GetValueByDevice/{Jobid}/{batchid}/{LineId}/{pOrder}/{MachineId}/{DeviceId}/{PerId}/{Date}")
    public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(
            @PathVariable String Jobid, @PathVariable String batchid, @PathVariable String LineId,
            @PathVariable int pOrder, @PathVariable String MachineId, @PathVariable String DeviceId,
            @PathVariable String PerId,
            @PathVariable(value = "Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date11) {
        return adminService.GetValueByDevice(Jobid, batchid, LineId, pOrder, MachineId, DeviceId, PerId, Date11);
    }


    @PostMapping("/saveAdmin")
    public ResponseEntity saveAdmin(@RequestBody AdminDTO adminDTO){

        try{
            String res = adminService.saveAdmin(adminDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully Added");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already Added");
                responseDTO.setContent(adminDTO);
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

    @PutMapping(value = "/updateAdmin/{adminid_ad}")
    public ResponseEntity updateAdmin(@RequestBody AdminDTO adminDTO){

        try{
            String res = adminService.updateAdmin(adminDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Added state not found");
                responseDTO.setContent(adminDTO);
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

    @GetMapping("/getAllAdmins")
    public ResponseEntity getAllAdmins(){
        try {
            List<AdminDTO> adminDTOList = adminService.getAllAdmins();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success");
            responseDTO.setContent(adminDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/searchAdmin/{adminid_ad}")
    public ResponseEntity searchAdmin(@PathVariable String adminid_ad){
        try {
            AdminDTO adminDTO = adminService.searchAdmin(adminid_ad);
            if (adminDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(adminDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No admin Available For this  ID");
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

    @DeleteMapping("/deleteAdmin/{adminid_ad}")
    public ResponseEntity deleteAdmin(@PathVariable String adminid_ad){
        try {
            String res = adminService.deleteAdmin(adminid_ad);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Delete Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No admin Available For this  id");
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
