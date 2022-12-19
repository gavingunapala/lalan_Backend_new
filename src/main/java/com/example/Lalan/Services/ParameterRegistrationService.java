package com.example.Lalan.Services;

import com.example.Lalan.DTO.ParameterRegistrationDTO;
import com.example.Lalan.Entity.ParameterRegistrationEntity;
import com.example.Lalan.Repos.ParameterRegistrationRepo;
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

public class ParameterRegistrationService {

    @Autowired
    private ParameterRegistrationRepo parameterRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save parameter Details
    public String saveParameter(ParameterRegistrationDTO parameterRegistrationDTO){
        if (parameterRegistrationRepo.existsById(parameterRegistrationDTO.getParameterId())){
            return VarList.RSP_DUPLICATED;
        }else {
            parameterRegistrationRepo.save(modelMapper.map(parameterRegistrationDTO, ParameterRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update parameter details...
    public String updateRegisteredParameter(ParameterRegistrationDTO parameterRegistrationDTO){
        if (parameterRegistrationRepo.existsById(parameterRegistrationDTO.getParameterId())){
            parameterRegistrationRepo.save(modelMapper.map(parameterRegistrationDTO, ParameterRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered parameter details...
    public List<ParameterRegistrationDTO> getAllParameters(){
        List<ParameterRegistrationEntity> parameterList = parameterRegistrationRepo.findAll();
        return modelMapper.map(parameterList,new TypeToken<ArrayList<ParameterRegistrationDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search parameter details using userId...
    public ParameterRegistrationDTO searchRegisteredParameter(String parameterId){
        if (parameterRegistrationRepo.existsById(parameterId)){
            ParameterRegistrationEntity parameterRegistrationEntity =parameterRegistrationRepo.findById(parameterId).orElse(null);
            return modelMapper.map(parameterRegistrationEntity, ParameterRegistrationDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered customer...
    public String deleteRegisteredParameter(String parameterId){
        if (parameterRegistrationRepo.existsById(parameterId)){
            parameterRegistrationRepo.deleteById(parameterId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
