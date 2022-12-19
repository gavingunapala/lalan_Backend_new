package com.example.Lalan.Services;

import com.example.Lalan.DTO.IOTInputProcessDTO;
import com.example.Lalan.Entity.IOTInputProcessEntity;
import com.example.Lalan.Repos.IOTInputProcessRepo;
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
public class IOTInputService {
    @Autowired
    private IOTInputProcessRepo iotInputRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save IOTInput Details
    public String saveIOTInput(IOTInputProcessDTO iotInputDTO){
        if (iotInputRepo.existsById(iotInputDTO.getIotInputId())){
            return VarList.RSP_DUPLICATED;
        }else {
            iotInputRepo.save(modelMapper.map(iotInputDTO, IOTInputProcessEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update IOTInput details...
    public String updateIOTInput(IOTInputProcessDTO iotInputDTO){
        if (iotInputRepo.existsById(iotInputDTO.getIotInputId())){
            iotInputRepo.save(modelMapper.map(iotInputDTO, IOTInputProcessEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered IOTInput details...
    public List<IOTInputProcessDTO> getAllIOTInputs(){
        List<IOTInputProcessEntity> iotInputList = iotInputRepo.findAll();
        return modelMapper.map(iotInputList,new TypeToken<ArrayList<IOTInputProcessDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search IOTInput details using jobId...
    public IOTInputProcessDTO searchRegisteredIOTInput(String iotInputId){
        if (iotInputRepo.existsById(iotInputId)){
            IOTInputProcessEntity iotInputEntity =iotInputRepo.findById(iotInputId).orElse(null);
            return modelMapper.map(iotInputEntity, IOTInputProcessDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered IOTInput...
    public String deleteRegisteredIOTInput(String iotInputId){
        if (iotInputRepo.existsById(iotInputId)){
            iotInputRepo.deleteById(iotInputId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
