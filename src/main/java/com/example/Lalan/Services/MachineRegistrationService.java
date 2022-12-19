package com.example.Lalan.Services;

import com.example.Lalan.DTO.MachineRegistrationDTO;
import com.example.Lalan.Entity.MachineRegistrationEntity;
import com.example.Lalan.Repos.MachineRegistrationRepo;
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

public class MachineRegistrationService {

    @Autowired
    private MachineRegistrationRepo machineRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;
    //----------------------------------------------------------------------------------------------
    //Save machine Details
    public String saveMachine(MachineRegistrationDTO machineRegistrationDTO){
        if (machineRegistrationRepo.existsById(machineRegistrationDTO.getMachineId())){
            return VarList.RSP_DUPLICATED;
        }else {
            machineRegistrationRepo.save(modelMapper.map(machineRegistrationDTO, MachineRegistrationEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //update machine details...
    public String updateRegisteredMachine(MachineRegistrationDTO machineRegistrationDTO){
        if (machineRegistrationRepo.existsById(machineRegistrationDTO.getMachineId())){
            machineRegistrationRepo.save(modelMapper.map(machineRegistrationDTO, MachineRegistrationEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered machine details...
    public List<MachineRegistrationDTO> getAllMachines(){
        List<MachineRegistrationEntity> macineList = machineRegistrationRepo.findAll();
        return modelMapper.map(macineList,new TypeToken<ArrayList<MachineRegistrationDTO>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
    //Search machine details using machineId...
    public MachineRegistrationDTO searchRegisteredMachine(String machineId){
        if (machineRegistrationRepo.existsById(machineId)){
            MachineRegistrationEntity machineRegistrationEntity =machineRegistrationRepo.findById(machineId).orElse(null);
            return modelMapper.map(machineRegistrationEntity, MachineRegistrationDTO.class);
        }else {
            return null;
        }
    }
    //--------------------------------------------------------------------------------------------------
    //Delete registered machine...
    public String deleteRegisteredMachine(String machineId){
        if (machineRegistrationRepo.existsById(machineId)){
            machineRegistrationRepo.deleteById(machineId);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
