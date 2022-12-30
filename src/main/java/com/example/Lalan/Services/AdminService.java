package com.example.Lalan.Services;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.DTO.BatchDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.BatchEntity;
import com.example.Lalan.Repos.AdminRepo;
import com.example.Lalan.DTO.LineRegistrationDTO;
import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.LineRegistrationEntity;

import com.example.Lalan.Util.VarList;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.hibernate.mapping.Value;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public String saveAdmin(AdminDTO adminDTO) {
        //if the batch is already there in the db return duplicate massage
        if (adminRepo.existsById(adminDTO.getAdminid_ad())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new batch to the db
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateAdmin(AdminDTO adminDTO) {
        //should be checked the batch is already exit
        if (adminRepo.existsById(adminDTO.getAdminid_ad())) {
            //if the batch is already there update the data
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the batch is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<AdminDTO> getAllAdmins() {
        //find the all data in db using findAll() and return as  list
        List<AdminEntity> adminList = adminRepo.findAll();
        return modelMapper.map(adminList, new TypeToken<ArrayList<AdminDTO>>() {

        }.getType());
    }

    public AdminDTO searchAdmin(String adminid_ad){
        if (adminRepo.existsById(adminid_ad)){
            AdminEntity admin = adminRepo.findById(adminid_ad).orElse(null);
            return modelMapper.map(admin,AdminDTO.class);
        }else {
            return null;
        }
    }

    public String deleteAdmin(String adminid_ad){
        //checked , the batch already in there
        if (adminRepo.existsById(adminid_ad)){
            //if the batch is exit delete the batch by batch id
            adminRepo.deleteById(adminid_ad);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
