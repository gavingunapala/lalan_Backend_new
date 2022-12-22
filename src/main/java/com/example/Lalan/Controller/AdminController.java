package com.example.Lalan.Controller;

import com.example.Lalan.DTO.ResponseDTO;
import com.example.Lalan.Entity.AdminEntity;
import com.example.Lalan.Entity.ParameterDeviceMachineEntity;
import com.example.Lalan.Services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getalldata")
    public List<Object[]> getalldata(){

        return  adminService.getall();
    }
}
