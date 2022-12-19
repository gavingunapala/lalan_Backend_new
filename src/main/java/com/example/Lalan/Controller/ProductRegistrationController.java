package com.example.Lalan.Controller;


import com.example.Lalan.DTO.ProductRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Services.ProductRegistrationService;
import com.example.Lalan.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductRegistrationController {

    @Autowired
    private ProductRegistrationService productRegistrationService;
    @Autowired
    private ResponseDTO responseDTO;
    //---------------------------------------------------------------------------------------------------------
    //saving product details.....
    @PostMapping(value = "/saveProduct")
    public ResponseEntity saveProduct(@RequestBody ProductRegistrationDTO productRegistrationDTO){
        try {
            String res=productRegistrationService.saveProduct(productRegistrationDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(productRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Product Registered!");
                responseDTO.setContent(productRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
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
    //Updating product details using product id...
    @PutMapping(value = "/updateRegisteredProduct/{productId}")
    public ResponseEntity   updateRegisteredProduct(@RequestBody ProductRegistrationDTO productRegistrationDTO){
        try {
            String res=productRegistrationService.updateRegisteredProduct(productRegistrationDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(productRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }else if(res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not A Registered Product");
                responseDTO.setContent(productRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
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
    //Display registered product...
    @GetMapping("/getAllProducts")
    public ResponseEntity getAllProducts(){
        try {
            List<ProductRegistrationDTO> productDTOList = productRegistrationService.getAllProducts();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(productDTOList);
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
    @GetMapping("/searchRegisteredProduct/{productId}")
    public ResponseEntity searchRegisteredProduct(@PathVariable String productId){
        try {
            ProductRegistrationDTO productRegistrationDTO = productRegistrationService.searchRegisteredProduct(productId);
            if (productRegistrationDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(productRegistrationDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No User Available For this productId");
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
    //Delete registered product using product id...
    @DeleteMapping("/deleteRegisteredProduct/{productId}")
    public ResponseEntity deleteRegisteredProduct(@PathVariable String productId){
        try {
            String res = productRegistrationService.deleteRegisteredProduct(productId);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success!");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Product is Available For this productId");
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
