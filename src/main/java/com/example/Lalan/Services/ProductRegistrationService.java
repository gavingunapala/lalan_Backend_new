package com.example.Lalan.Services;

import com.example.Lalan.DTO.ProductRegistrationDTO;
import com.example.Lalan.Entity.ProductRegistrationEntity;
import com.example.Lalan.Repos.ProductRegistrationRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductRegistrationService {

    @Autowired
    private ProductRegistrationRepo productRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save product Details
    public String saveProduct(ProductRegistrationDTO productRegistrationDTO){
        if (productRegistrationRepo.existsById(productRegistrationDTO.getProductId())){
            return VarList.RSP_DUPLICATED;
        }else {
            productRegistrationRepo.save(modelMapper.map(productRegistrationDTO, ProductRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update product details...
    public String updateRegisteredProduct(ProductRegistrationDTO productRegistrationDTO){
        if (productRegistrationRepo.existsById(productRegistrationDTO.getProductId())){
            productRegistrationRepo.save(modelMapper.map(productRegistrationDTO, ProductRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered product details...
    public List<ProductRegistrationDTO> getAllProducts(){
        List<ProductRegistrationEntity> productList = productRegistrationRepo.findAll();
        return modelMapper.map(productList,new TypeToken<ArrayList<ProductRegistrationDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search product details using productId...
    public ProductRegistrationDTO searchRegisteredProduct(String productId){
        if (productRegistrationRepo.existsById(productId)){
            ProductRegistrationEntity productRegistrationEntity =productRegistrationRepo.findById(productId).orElse(null);
            return modelMapper.map(productRegistrationEntity, ProductRegistrationDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered product using producr id...
    public String deleteRegisteredProduct(String productId){
        if (productRegistrationRepo.existsById(productId)){
            productRegistrationRepo.deleteById(productId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
