package com.example.Lalan.Services;

import com.example.Lalan.Entity.AdminEntity;

import com.example.Lalan.Repos.AdminRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Object[]> getall(){

        return  adminRepo.getalljobidsbyprocedure();
    }
}
