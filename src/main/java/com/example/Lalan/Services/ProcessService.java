package com.example.Lalan.Services;

import com.example.Lalan.DTO.ProcessDTO;
import com.example.Lalan.Entity.ProcessEntity;
import com.example.Lalan.Repos.ProcessRepo;
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

public class ProcessService {

    @Autowired
    private ProcessRepo processRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a process to the database
    public String saveProcess(ProcessDTO processDTO) {
        //if the process is already there in the db return duplicate massage
        if (processRepo.existsById(processDTO.getProductID_proConf())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new process to the db
            processRepo.save(modelMapper.map(processDTO, ProcessEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateProcess(ProcessDTO processDTO) {
        //should be checked the process is already exit
        if (processRepo.existsById(processDTO.getProductID_proConf())) {
            //if the process is already there update the data
            processRepo.save(modelMapper.map(processDTO, ProcessEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the process is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<ProcessDTO> getAllProcess() {
        //find the all data in db using findAll() and return as  list
        List<ProcessEntity> processList = processRepo.findAll();
        return modelMapper.map(processList, new TypeToken<ArrayList<ProcessDTO>>() {

        }.getType());
    }

    public ProcessDTO searchProcess(String proConf_id){
        if (processRepo.existsById(proConf_id)){
            ProcessEntity process = processRepo.findById(proConf_id).orElse(null);
            return modelMapper.map(process,ProcessDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific batch by id
    public String deleteProcess(String proConf_id){
        //checked , the process already in there
        if (processRepo.existsById(proConf_id)){
            //if the process is exit delete the batch by batch id
            processRepo.deleteById(proConf_id);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
