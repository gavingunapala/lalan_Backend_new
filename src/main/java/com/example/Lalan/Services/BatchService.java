package com.example.Lalan.Services;

import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Repos.BatchRepo;
import com.example.Lalan.Util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class BatchService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private ModelMapper modelMapper;



    //save a batch to the database
    public String saveBatch(BatchDTO batchDTO) {
        //if the batch is already there in the db return duplicate massage
        if (batchRepo.existsById(batchDTO.getBatchID_regBch())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new batch to the db
            batchRepo.save(modelMapper.map(batchDTO, BatchEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateBatch(BatchDTO batchDTO) {
        //should be checked the batch is already exit
        if (batchRepo.existsById(batchDTO.getBatchID_regBch())) {
            //if the batch is already there update the data
            batchRepo.save(modelMapper.map(batchDTO, BatchEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the batch is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<BatchDTO> getAllBatches() {
        //find the all data in db using findAll() and return as  list
        List<BatchEntity> batchList = batchRepo.findAll();
        return modelMapper.map(batchList, new TypeToken<ArrayList<BatchDTO>>() {

        }.getType());
    }

    public BatchDTO searchBatch(String batchID_regBch){
        if (batchRepo.existsById(batchID_regBch)){
            BatchEntity batch = batchRepo.findById(batchID_regBch).orElse(null);
            return modelMapper.map(batch,BatchDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific batch by id
    public String deleteBatch(String batchID_regBch){
        //checked , the batch already in there
        if (batchRepo.existsById(batchID_regBch)){
            //if the batch is exit delete the batch by batch id
            batchRepo.deleteById(batchID_regBch);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
