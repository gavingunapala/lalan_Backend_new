package com.example.Lalan.Controller;

import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.BatchService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/batch")

public class BatchController {

    @Autowired
    private BatchService batchService;

    @Autowired
    private ResponseDTO responseDTO;

    //drop down list

    //ModelAttribute in here under the ma name goes front end name of batch registration
    @ModelAttribute(name = "studentForm")
    public BatchDTO setUp() {
        return new BatchDTO();
    }

   /* @GetMapping
    public String list(Model model) {
        List<BatchDTO> students = BatchService.listAll();
        // add to model
        model.addAttribute("allStudent", students);
        // view
        return "index";
    }*/

    @PostMapping("/saveBatch")
    public ResponseEntity saveBatch(@RequestBody BatchDTO batchDTO){

        try{
            String res = batchService.saveBatch(batchDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Successfully Registered");
                responseDTO.setContent(batchDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already Registered");
                responseDTO.setContent(batchDTO);
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
    @PutMapping(value = "/updateBatch/{batchID_regBch}")
    public ResponseEntity updateBatch(@RequestBody BatchDTO batchDTO){

        try{
            String res = batchService.updateBatch(batchDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Update Success");
                responseDTO.setContent(batchDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage(" Registered state not found");
                responseDTO.setContent(batchDTO);
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

    @GetMapping("/getAllBatches")
    public ResponseEntity getAllBatches(){
        try {
            List<BatchDTO> batchDTOList = batchService.getAllBatches();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("getting Success");
            responseDTO.setContent(batchDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/searchBatch/{batchID_regBch}")
    public ResponseEntity searchBatch(@PathVariable String batchID_regBch){
        try {
            BatchDTO batchDTO = batchService.searchBatch(batchID_regBch);
            if (batchDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(batchDTO);
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

    @DeleteMapping("/deleteBatch/{batchID_regBch}")
    public ResponseEntity deleteBatch(@PathVariable String batchID_regBch){
        try {
            String res = batchService.deleteBatch(batchID_regBch);
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


}
