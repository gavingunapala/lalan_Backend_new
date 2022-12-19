package com.example.Lalan.Controller;

import com.example.Lalan.DTO.JobRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.JobRegistraionService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/job")

public class JobRegistrationController {

    @Autowired
    private JobRegistraionService jobRegistraionService;
    @Autowired
    private ResponseDTO responseDTO;
    //---------------------------------------------------------------------------------------------------------
    //saving job details.....
    @PostMapping(value = "/saveJob")
    public ResponseEntity saveJob(@RequestBody JobRegistrationDTO jobRegistrationDTO){
        try {
            String res=jobRegistraionService.saveJob(jobRegistrationDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(jobRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Registered!");
                responseDTO.setContent(jobRegistrationDTO);
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
    //Updating job details...
    @PutMapping(value = "/updateRegisteredJob/{jobId}")
    public ResponseEntity   updateRegisteredJob(@RequestBody JobRegistrationDTO jobRegistrationDTO){
        try {
            String res=jobRegistraionService.updateRegisteredJob(jobRegistrationDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(jobRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered User");
                responseDTO.setContent(jobRegistrationDTO);
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
    //Display registered job...
    @GetMapping("/getAllJobs")
    public ResponseEntity getAllJobs(){
        try {
            List<JobRegistrationDTO> jobList = jobRegistraionService.getAllJobs();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success!");
            responseDTO.setContent(jobList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //--------------------------------------------------------------------------------------------------
    //Search job details using jobId...
    @GetMapping("/searchRegisteredJob/{jobId}")
    public ResponseEntity searchRegisteredJob(@PathVariable String jobId){
        try {
            JobRegistrationDTO jobRegistrationDTO = jobRegistraionService.searchRegisteredJob(jobId);
            if (jobRegistrationDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(jobRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this jobId");
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
    //Delete registered job...
    @DeleteMapping("/deleteRegisteredJob/{jobId}")
    public ResponseEntity deleteRegisteredJob(@PathVariable String jobId){
        try {
            String res = jobRegistraionService.deleteRegisteredJob(jobId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this jobId");
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
