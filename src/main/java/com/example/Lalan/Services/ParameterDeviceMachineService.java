package com.example.Lalan.Services;

import com.example.Lalan.DTO.ParameterDeviceMachineDTO;
import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import com.example.Lalan.Repos.ParameterDeviceMachineRepo;
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
public class ParameterDeviceMachineService {

    @Autowired
    private ParameterDeviceMachineRepo parameterDeviceMachineRepo;

    @Autowired
    private ModelMapper modelMapper;


    //save a PDM record to the database
    //PDM-Parameter device machine
    public String savePDM(ParameterDeviceMachineDTO parameterDeviceMachineDTO) {
        //if the PDM record is already there in the db return duplicate massage
        if (parameterDeviceMachineRepo.existsById(parameterDeviceMachineDTO.getParaId_PDM())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new PDM record to the db
            parameterDeviceMachineRepo.save(modelMapper.map(parameterDeviceMachineDTO, ParameterDeviceMachineEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updatePDM(ParameterDeviceMachineDTO parameterDeviceMachineDTO) {
        //should be checked the admin record is already exit
        if (parameterDeviceMachineRepo.existsById(parameterDeviceMachineDTO.getParaId_PDM())) {
            //if the admin record is already there update the data
            parameterDeviceMachineRepo.save(modelMapper.map(parameterDeviceMachineDTO, ParameterDeviceMachineEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the admin record is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<ParameterDeviceMachineDTO> getAllPDM() {
        //find the all data in db using findAll() and return as  list//here  i changed
        List<ParameterDeviceMachineEntity> PDMList = (List<ParameterDeviceMachineEntity>) parameterDeviceMachineRepo.findAll();
        return modelMapper.map(PDMList, new TypeToken<ArrayList<ParameterDeviceMachineDTO>>() {

        }.getType());
    }
    public ParameterDeviceMachineDTO searchPDM(String paraId_PDM){
        if (parameterDeviceMachineRepo.existsById(paraId_PDM)){
            ParameterDeviceMachineEntity PaDeMa = parameterDeviceMachineRepo.findById(paraId_PDM).orElse(null);
            return modelMapper.map(PaDeMa,ParameterDeviceMachineDTO.class);
        }else {
            return null;
        }
    }
    //delete a specific PDM record by id
    public String deletePDM(String paraId_PDM){
        //checked , the admin record already in there
        if (parameterDeviceMachineRepo.existsById(paraId_PDM)){
            //if the admin record is exit delete the admin record by admin record id
            parameterDeviceMachineRepo.deleteById(paraId_PDM);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public  List <ParameterDeviceMachineEntity> getall(){
        return parameterDeviceMachineRepo.getalldevices();
    }

    public  List <ParameterDeviceMachineEntity> getallparas(){
        return parameterDeviceMachineRepo.getallparameters();
    }

    public List<ParameterDeviceMachineEntity>getMachineDetailsFmId(String mID){
        return parameterDeviceMachineRepo.getDetailsByMachineID(mID);
    }



}
