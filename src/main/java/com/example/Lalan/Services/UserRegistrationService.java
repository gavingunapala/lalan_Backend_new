package com.example.Lalan.Services;

import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Entity.UserRegistrationEntity;
import com.example.Lalan.Repos.UserRegistrationRepo;
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

public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save user Details
    public String saveUser(UserRegistrationDTO userRegisterDTO){
        if (userRegistrationRepo.existsById(userRegisterDTO.getUserId())){
            return VarList.RSP_DUPLICATED;
        }else {
            userRegistrationRepo.save(modelMapper.map(userRegisterDTO, UserRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update user details...
    public String updateRegisteredUser(UserRegistrationDTO userRegisterDTO){
        if (userRegistrationRepo.existsById(userRegisterDTO.getUserId())){
            userRegistrationRepo.save(modelMapper.map(userRegisterDTO, UserRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered users details...
    public List<UserRegistrationDTO> getAllUsers(){
        List<UserRegistrationEntity> userList = userRegistrationRepo.findAll();
        return modelMapper.map(userList,new TypeToken<ArrayList<UserRegistrationDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search job details using jobId...
    public UserRegistrationDTO searchRegisteredUser(String userId){
        if (userRegistrationRepo.existsById(userId)){
            UserRegistrationEntity userRegister =userRegistrationRepo.findById(userId).orElse(null);
            return modelMapper.map(userRegister, UserRegistrationDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered user...
    public String deleteRegisteredUser(String userId){
        if (userRegistrationRepo.existsById(userId)){
            userRegistrationRepo.deleteById(userId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
