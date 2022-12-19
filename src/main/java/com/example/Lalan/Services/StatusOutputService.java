package com.example.Lalan.Services;

import com.example.Lalan.DTO.StatusOutputDTO;
import com.example.Lalan.Entity.StatusOutputEntity;
import com.example.Lalan.Repos.StatusOutputRepo;
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

public class StatusOutputService {

    @Autowired
    private StatusOutputRepo statusOutputRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a system output to the database
    public String saveOutput(StatusOutputDTO statusOutputDTO) {
        //if the status output is already there in the db return duplicate massage
        if (statusOutputRepo.existsById(statusOutputDTO.getStatusOutputID())) {//StatusOutputID
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a status output record to the db
            statusOutputRepo.save(modelMapper.map(statusOutputDTO, StatusOutputEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateOutput(StatusOutputDTO statusOutputDTO) {
        //should be checked the status output is already exit
        if (statusOutputRepo.existsById(statusOutputDTO.getStatusOutputID())) {
            //if the admin record is already there update the data
            statusOutputRepo.save(modelMapper.map(statusOutputDTO, StatusOutputEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the status output is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<StatusOutputDTO> getAllOutputs() {
        //find the all data in db using findAll() and return as  list
        List<StatusOutputEntity> statusOutputList = statusOutputRepo.findAll();
        return modelMapper.map(statusOutputList, new TypeToken<ArrayList<StatusOutputDTO>>() {

        }.getType());
    }

    public StatusOutputDTO searchOutput(String StatusOutputID){
        if (statusOutputRepo.existsById(StatusOutputID)){
            StatusOutputEntity batch = statusOutputRepo.findById(StatusOutputID).orElse(null);
            return modelMapper.map(batch,StatusOutputDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific status output by id
    public String deleteOutput(String StatusOutputID){
        //checked , the status output already in there
        if (statusOutputRepo.existsById(StatusOutputID)){
            //if the status output is exit delete the admin record by admin record id
            statusOutputRepo.deleteById(StatusOutputID);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
