package com.example.Lalan.Services;

import com.example.Lalan.DTO.DeviceDTO;
import com.example.Lalan.Entity.DeviceEntity;
import com.example.Lalan.Repos.DeviceRepo;
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
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save a device to the database
    public String saveDevice(DeviceDTO deviceDTO) {
        //if the product is already there in the db return duplicate massage
        if (deviceRepo.existsById(deviceDTO.getDeviceID_dvcReg())) {//deviceID_dvcReg
            return VarList.RSP_DUPLICATED;

        } else {
            //if not save a new device to the db
            deviceRepo.save(modelMapper.map(deviceDTO, DeviceEntity.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateDevice(DeviceDTO deviceDTO) {
        //should be checked the device is already exit
        if (deviceRepo.existsById(deviceDTO.getDeviceID_dvcReg())) {
            //if the device is already there update the data
            deviceRepo.save(modelMapper.map(deviceDTO, DeviceEntity.class));
            return VarList.RSP_SUCCESS;
        } else {
            // if the user is not already there return error
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<DeviceDTO> getAllDevice() {
        //find the all data in db using findAll() and return as  list
        List<DeviceEntity> deviceList = deviceRepo.findAll();
        return modelMapper.map(deviceList, new TypeToken<ArrayList<DeviceDTO>>() {

        }.getType());
    }

    public DeviceDTO searchDevice(String deviceID){
        if (deviceRepo.existsById(deviceID)){
            DeviceEntity device =deviceRepo.findById(deviceID).orElse(null);
            return modelMapper.map(device,DeviceDTO.class);
        }else {
            return null;
        }
    }

    //delete a specific device by id
    public String deleteDevice(String deviceID){
        //checked , the device already in there
        if (deviceRepo.existsById(deviceID)){
            //if the device is exit delete the device by using id
            deviceRepo.deleteById(deviceID);
            //and return a success massage
            return VarList.RSP_SUCCESS;
        }else {
            //if not return an error message
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


}
