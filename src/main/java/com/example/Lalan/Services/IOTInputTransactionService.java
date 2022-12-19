package com.example.Lalan.Services;

import com.example.Lalan.DTO.IOTInputHistoryDTO;
import com.example.Lalan.DTO.IOTInputTransactionDTO;
import com.example.Lalan.DTO.UserRegistrationDTO;
import com.example.Lalan.Entity.IOTInputHistoryEntity;
import com.example.Lalan.Entity.IOTInputTransactionEntity;
import com.example.Lalan.Entity.UserRegistrationEntity;
import com.example.Lalan.Repos.IOTInputHistoryRepo;
import com.example.Lalan.Repos.IOTInputTransactionRepo;
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
public class IOTInputTransactionService {
    @Autowired
    private IOTInputTransactionRepo iotInputTransactionRepo;

    @Autowired
    private ModelMapper modelMapper;


    //----------------------------------------------------------------------------------------------------
    //update IOTInputTransaction details...
    public String updateRegisteredIOTInputTransaction(IOTInputTransactionDTO iotInputTransactionDTO){
        if (iotInputTransactionRepo.existsById(iotInputTransactionDTO.getIotInputTraId())){
            iotInputTransactionRepo.save(modelMapper.map(iotInputTransactionDTO, IOTInputTransactionEntity.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    //----------------------------------------------------------------------------------------------------
    //Display registered IOTInputTransaction details...
    public List<IOTInputTransactionDTO> getAllIOTInputTransactional(){
        List<IOTInputTransactionEntity> iotInputTransactionList = iotInputTransactionRepo.findAll();
        return modelMapper.map(iotInputTransactionList,new TypeToken<ArrayList<IOTInputTransactionService>>(){
        }.getType());
    }
    //-----------------------------------------------------------------------------------------------------
}
