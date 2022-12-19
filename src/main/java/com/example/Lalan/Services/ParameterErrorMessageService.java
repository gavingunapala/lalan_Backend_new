package com.example.Lalan.Services;

import com.example.Lalan.DTO.ParameterErrorMessageDTO;
import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Entity.ParameterErrorMessageEntity;
import com.example.Lalan.Entity.ParameterRegistrationEntity;
import com.example.Lalan.Entity.UserRegistrationEntity;
import com.example.Lalan.Repos.ParameterErrorMessageRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ParameterErrorMessageService {
    @Autowired
    private ParameterErrorMessageRepo parameterErrorMessageRepo;

    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save parameterErrorMessage Details
    public String saveParameterErrorMessage(ParameterErrorMessageDTO parameterErrorMessageDTO){
        if (parameterErrorMessageRepo.existsById(parameterErrorMessageDTO.getParameterErrorMsgId())){
            return VarList.RSP_DUPLICATED;
        }else {
            parameterErrorMessageRepo.save(modelMapper.map(parameterErrorMessageDTO, ParameterErrorMessageEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update parameterErrorMessage details...
    public String updateRegisteredParameterErrorMessage(ParameterErrorMessageDTO parameterErrorMessageDTO){
        if (parameterErrorMessageRepo.existsById(parameterErrorMessageDTO.getParameterErrorMsgId())){
            parameterErrorMessageRepo.save(modelMapper.map(parameterErrorMessageDTO, ParameterErrorMessageEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered parameterErrorMessage details...
    public List<ParameterErrorMessageDTO> getAllParameterErrorMessage(){
        List<ParameterErrorMessageEntity> parameterErrorMessageList = parameterErrorMessageRepo.findAll();
        return modelMapper.map(parameterErrorMessageList,new TypeToken<ArrayList<ParameterErrorMessageDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search job details using jobId...
    public ParameterErrorMessageDTO searchRegisteredParameterErrorMessage(String parameterErrorMsgId){
        if (parameterErrorMessageRepo.existsById(parameterErrorMsgId)){
            ParameterErrorMessageEntity parameterErrorMessageEntity =parameterErrorMessageRepo.findById(parameterErrorMsgId).orElse(null);
            return modelMapper.map(parameterErrorMessageEntity, ParameterErrorMessageDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered parameterErrorMessage...
    public String deleteRegisteredParameterErrorMessage(String parameterErrorMsgId){
        if (parameterErrorMessageRepo.existsById(parameterErrorMsgId)){
            parameterErrorMessageRepo.deleteById(parameterErrorMsgId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
