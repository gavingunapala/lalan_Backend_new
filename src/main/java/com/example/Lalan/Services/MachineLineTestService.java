package com.example.Lalan.Services;

import com.example.Lalan.DTO.MachineLineTestDTO;
import com.example.Lalan.DTO.MachineRegistrationDTO;
import com.example.Lalan.Entity.MachineLineTestEntity;
import com.example.Lalan.Entity.MachineRegistrationEntity;
import com.example.Lalan.Repos.MachineLineTestRepo;
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
public class MachineLineTestService {
    @Autowired
    private MachineLineTestRepo machineLineTestRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveMachineLineTest(MachineLineTestDTO machineLineTestDTO) {
        //if the admin record is already there in the db return duplicate massage
        if (machineLineTestRepo.existsById(machineLineTestDTO.getMachineLineID())) {
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new admin record to the db
            machineLineTestRepo.save(modelMapper.map(machineLineTestDTO, MachineLineTestEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public List<MachineLineTestDTO> getAllMachineLineTest() {
        //find the all data in db using findAll() and return as  list
        List<MachineLineTestEntity> machinelineList =     machineLineTestRepo.findAll();
        return modelMapper.map(machinelineList, new TypeToken<ArrayList<MachineLineTestDTO>>() {

        }.getType());
    }

    public MachineLineTestDTO searchMachineLineTest(String machineLineID){
        if (machineLineTestRepo.existsById(machineLineID)){
            MachineLineTestEntity machine = machineLineTestRepo.findById(machineLineID).orElse(null);
            return modelMapper.map(machine,MachineLineTestDTO.class);
        }else {
            return null;
        }
    }

    //query method
    public MachineLineTestDTO  getMachineLineTestById(String machineLineID){
        MachineLineTestEntity machine = machineLineTestRepo.getMachineLineTestById(machineLineID);
        return modelMapper.map(machine, MachineLineTestDTO.class);
    }

    
//    public MachineLineTestDTO  getallMachineLineTest(String machineLineID){
//        List<MachineLineTestEntity> machine = machineLineTestRepo.getMachineLineTestById(machineLineID);
//        return modelMapper.map(machine, MachineLineTestDTO.class);
//    }

    public  List <MachineLineTestEntity> getall(){
        return machineLineTestRepo.getallmachine();
    }

//    public List<MachineLineTestEntity> getalltestsbyid(String machine_lineid) {
//        return machineLineTestRepo.getallmachinebyid(machine_lineid);
//    }

}
