package com.example.Lalan.Services;

import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.DTO.CustomerRegistrationDTO;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Entity.CustomerRegistrationEntity;
import com.example.Lalan.Repos.BatchRepo;
import com.example.Lalan.Repos.CustomerRegistrationRepo;
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
public class CustomerRegistrationService {

    @Autowired
    private CustomerRegistrationRepo customerRegistrationRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String saveCustomerRegistration(CustomerRegistrationDTO customerRegistrationDTO) {
        if (customerRegistrationRepo.existsById(customerRegistrationDTO.getCus_id())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new batch to the db
            customerRegistrationRepo.save(modelMapper.map(customerRegistrationDTO, CustomerRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCustomerRegistration(CustomerRegistrationDTO customerRegistrationDTO) {
        //should be checked the batch is already exit
        if (customerRegistrationRepo.existsById(customerRegistrationDTO.getCus_id())) {
            //if the batch is already there update the data
            customerRegistrationRepo.save(modelMapper.map(customerRegistrationDTO, CustomerRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the batch is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<CustomerRegistrationDTO> getAllCustomerRegistration() {
        //find the all data in db using findAll() and return as  list
        List<CustomerRegistrationEntity> customerList = customerRegistrationRepo.findAll();
        return modelMapper.map(customerList, new TypeToken<ArrayList<CustomerRegistrationDTO>>() {

        }.getType());
    }

    public CustomerRegistrationDTO searchCustomerRegistration(String Cus_id){
        if (customerRegistrationRepo.existsById(Cus_id)){
            CustomerRegistrationEntity customer = customerRegistrationRepo.findById(Cus_id).orElse(null);
            return modelMapper.map(customer,CustomerRegistrationDTO.class);
        }else {
            return null;
        }
    }
    public String deleteCustomerRegistration(String Cus_id){

        if (customerRegistrationRepo.existsById(Cus_id)){

            customerRegistrationRepo.deleteById(Cus_id);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
