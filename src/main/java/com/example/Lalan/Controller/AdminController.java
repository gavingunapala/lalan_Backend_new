package com.example.Lalan.Controller;

import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;
import com.example.Lalan.Services.AdminService;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import org.springframework.beans.factory.annotation.Autowired;
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

}
