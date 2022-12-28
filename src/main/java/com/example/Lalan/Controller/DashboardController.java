package com.example.Lalan.Controller;

import com.example.Lalan.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


//    @GetMapping("/getalldashboarddata")
//    public List<Object[]> getalldata(){
//
//        return  dashboardService.getall();
//    }

//    @GetMapping("/getalldatawithdate/{Date}")
//    public List<Object[]>  getalldata(@PathVariable Date predicted_date){
//
//        return  dashboardService.getalldata(predicted_date);
//    }


}
