package com.example.Lalan.Services;

import com.example.Lalan.DTO.IOTInputHistoryDTO;
import com.example.Lalan.Entity.IOTInputHistoryEntity;
import com.example.Lalan.Repos.IOTInputHistoryRepo;
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
public class IOTInputHistoryService {
    @Autowired
    private IOTInputHistoryRepo iotInputHistoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    //----------------------------------------------------------------------------------------------
    //Save IOTInputHistory Details
    public String SaveIOTInputHistory(IOTInputHistoryDTO iotInputHistoryDTO){
        if (iotInputHistoryRepo.existsById(iotInputHistoryDTO.getIotInputHisId())){
            return VarList.RSP_DUPLICATED;
        }else {
            iotInputHistoryRepo.save(modelMapper.map(iotInputHistoryDTO, IOTInputHistoryEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update IOTInputHistory details...
    public String updateRegisteredIOTInputHistory(IOTInputHistoryDTO iotInputHistoryDTO){
        if (iotInputHistoryRepo.existsById(iotInputHistoryDTO.getIotInputHisId())){
            iotInputHistoryRepo.save(modelMapper.map(iotInputHistoryDTO, IOTInputHistoryEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered IOTInputHistory details...
    public List<IOTInputHistoryDTO> getAllIOTInputHistory(){
        List<IOTInputHistoryEntity> iotInputList = iotInputHistoryRepo.findAll();
        return modelMapper.map(iotInputList,new TypeToken<ArrayList<IOTInputHistoryDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search IOTInputHistory details using iotInputHisId...
    public IOTInputHistoryDTO searchRegisteredIOTInputHistory(String iotInputHisId){
        if (iotInputHistoryRepo.existsById(iotInputHisId)){
            IOTInputHistoryEntity iotInputHistoryEntity =iotInputHistoryRepo.findById(iotInputHisId).orElse(null);
            return modelMapper.map(iotInputHistoryEntity, IOTInputHistoryDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered IOTInputHistory...
    public String deleteRegisteredIOTInputHistory(String iotInputHisId){
        if (iotInputHistoryRepo.existsById(iotInputHisId)){
            iotInputHistoryRepo.deleteById(iotInputHisId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
