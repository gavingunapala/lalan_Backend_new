package com.example.Lalan.Services;

import com.example.Lalan.Repos.AdminRepo;
import com.example.Lalan.Repos.DashboardRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DashboardService {

    @Autowired
    private DashboardRepo dashboardRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public List<Object[]> getall(){
//
//        return  dashboardRepo.getallbashboarddetails();
//    }


//   public List<Object[]>  getalldata(Date predicted_date) {
//       return dashboardRepo.getallbashboarddetails(predicted_date);
//   }


}

