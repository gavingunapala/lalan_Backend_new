package com.example.Lalan.Services;

import com.example.Lalan.Repos.AdminRepo;
import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    // call repo query to get all batch ids when select job id
    public List<Object[]> getallbatches(String job_id_ad) {
        return adminRepo.getallbactchidssbyprocedure(job_id_ad);
    }

    public List<Map<ActiveObjectMap.Key, Value>> getLineByDate(Date predicted_date) {
        return adminRepo.getLineByDate(predicted_date);
    }

    // get Get Customer Details By Date And LineId
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineId(Date predicted_date, String LineId) {
        return adminRepo.GetDetailsByDateAndLineId(predicted_date, LineId);
    }

    // get Get machine Details By Date And LineId and POrder
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrder(Date predicted_date, String LineId,
            int pOrder) {
        return adminRepo.GetDetailsByDateAndLineIdAndPOrder(predicted_date, LineId, pOrder);
    }

    // get Get Perameters By Date And LineId and pOrder and Machine Id
    public List<Map<ActiveObjectMap.Key, Value>> GetDetailsByDateAndLineIdAndPOrderAndMachineId(Date predicted_date,
            String LineId, int pOrder, String MachineId) {
        return adminRepo.GetDetailsByDateAndLineIdAndPOrderAndMachineId(predicted_date, LineId, pOrder, MachineId);
    }

    // get values to the table
    public List<Map<ActiveObjectMap.Key, Value>> GetValueByDevice(String Jobid, String batchid, String LineId,
            int pOrder, String MachineId, String DeviceId, String PerId, Date Date11) {
        return adminRepo.GetValueByDevice(Jobid, batchid, LineId, pOrder, MachineId, DeviceId, PerId, Date11);
    }
}
