package com.example.Lalan.Services;

import com.example.Lalan.DTO.LogDTO;
import com.example.Lalan.Entity.LogEntity;
import com.example.Lalan.Repos.LogRepo;
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

public class LogService {

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a batch to the database
    public String saveLog(LogDTO logDTO) {
        //if the log is already there in the db return duplicate massage
        if (logRepo.existsById(logDTO.getLogID_lg())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new log to the db
            logRepo.save(modelMapper.map(logDTO, LogEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateLog(LogDTO logDTO) {
        //should be checked the log is already exit
        if (logRepo.existsById(logDTO.getLogID_lg())) {
            //if the log is already there update the data
            logRepo.save(modelMapper.map(logDTO, LogEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the log is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<LogDTO> getAllLogs() {
        //find the all data in db using findAll() and return as  list
        List<LogEntity> logList = logRepo.findAll();
        return modelMapper.map(logList, new TypeToken<ArrayList<LogDTO>>() {

        }.getType());
    }

    public LogDTO searchLog(String logID_lg){
        if (logRepo.existsById(logID_lg)){
            LogEntity log = logRepo.findById(logID_lg).orElse(null);
            return modelMapper.map(log,LogDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific log by id
    public String deleteLog(String logID_lg){
        //checked , the log already in there
        if (logRepo.existsById(logID_lg)){
            //if the log is exit delete the log by log id
            logRepo.deleteById(logID_lg);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
