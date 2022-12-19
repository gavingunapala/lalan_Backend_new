package com.example.Lalan.Services;

import com.example.Lalan.DTO.StatusDTO;
import com.example.Lalan.Entity.StatusEntity;
import com.example.Lalan.Repos.StatusRepo;
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

public class StatusService {

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a status record to the database
    public String saveStatus(StatusDTO statusDTO) {
        //if the status is already there in the db return duplicate massage
        if (statusRepo.existsById(statusDTO.getStatusID_st())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new status to the db
            statusRepo.save(modelMapper.map(statusDTO, StatusEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateStatus(StatusDTO statusDTO) {
        //should be checked the status record is already exit
        if (statusRepo.existsById(statusDTO.getStatusID_st())) {
            //if the status is already there update the data
            statusRepo.save(modelMapper.map(statusDTO, StatusEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the status is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<StatusDTO> getAllStatus() {
        //find the all data in db using findAll() and return as  list
        List<StatusEntity> StatusList = statusRepo.findAll();
        return modelMapper.map(StatusList, new TypeToken<ArrayList<StatusDTO>>() {

        }.getType());
    }

    public StatusDTO searchStatus(String statusID_st){
        if (statusRepo.existsById(statusID_st)){
            StatusEntity status = statusRepo.findById(statusID_st).orElse(null);
            return modelMapper.map(status,StatusDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific status by id
    public String deleteStatus(String statusID_st){
        //checked , the status already in there
        if (statusRepo.existsById(statusID_st)){
            //if the status is exit delete the status by status id
            statusRepo.deleteById(statusID_st);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
