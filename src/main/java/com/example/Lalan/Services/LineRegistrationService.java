package com.example.Lalan.Services;

import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;
import com.example.Lalan.Repos.LineRegistrationRepo;
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

public class LineRegistrationService {

    @Autowired
    private LineRegistrationRepo lineRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save Line Details
    public String saveLine(LineRegistrationDTO lineRegistrationDTO){
        if (lineRegistrationRepo.existsById(lineRegistrationDTO.getLineId())){
            return VarList.RSP_DUPLICATED;
        }else {
            lineRegistrationRepo.save(modelMapper.map(lineRegistrationDTO, LineRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update line details...
    public String updateRegisteredLine(LineRegistrationDTO lineRegistrationDTO){
        if (lineRegistrationRepo.existsById(lineRegistrationDTO.getLineId())){
            lineRegistrationRepo.save(modelMapper.map(lineRegistrationDTO, LineRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered line details...
    public List<LineRegistrationDTO> getAllLines(){
        List<LineRegistrationEntity> lineList = lineRegistrationRepo.findAll();
        return modelMapper.map(lineList,new TypeToken<ArrayList<LineRegistrationDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search line details using lineId...
    public LineRegistrationDTO searchRegisteredLine(String lineId){
        if (lineRegistrationRepo.existsById(lineId)){
            LineRegistrationEntity lineRegistrationEntity =lineRegistrationRepo.findById(lineId).orElse(null);
            return modelMapper.map(lineRegistrationEntity, LineRegistrationDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered customer...
    public String deleteRegisteredLine(String lineId){
        if (lineRegistrationRepo.existsById(lineId)){
            lineRegistrationRepo.deleteById(lineId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
