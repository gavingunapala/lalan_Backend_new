package com.example.Lalan.Services;

import com.example.Lalan.DTO.AdminDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Repos.AdminRepo;
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

public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a admin record to the database
    public String saveAdmin(AdminDTO adminDTO) {
        //if the admin record is already there in the db return duplicate massage
        if (adminRepo.existsById(adminDTO.getAdminID_ad())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new admin record to the db
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateAdmin(AdminDTO adminDTO) {
        //should be checked the admin record is already exit
        if (adminRepo.existsById(adminDTO.getAdminID_ad())) {
            //if the admin record is already there update the data
            adminRepo.save(modelMapper.map(adminDTO, AdminEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the admin record is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<AdminDTO> getAllAdmin() {
        //find the all data in db using findAll() and return as  list
        List<AdminEntity> adminList = adminRepo.findAll();
        return modelMapper.map(adminList, new TypeToken<ArrayList<AdminDTO>>() {

        }.getType());
    }

    public AdminDTO searchAdmin(String adminID_ad){
        if (adminRepo.existsById(adminID_ad)){
            AdminEntity batch = adminRepo.findById(adminID_ad).orElse(null);
            return modelMapper.map(batch,AdminDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific admin record by id
    public String deleteAdmin(String admin_id){
        //checked , the admin record already in there
        if (adminRepo.existsById(admin_id)){
            //if the admin record is exit delete the admin record by admin record id
            adminRepo.deleteById(admin_id);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
