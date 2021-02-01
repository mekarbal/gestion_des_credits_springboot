package com.spring_credit.start.controllers;

import com.spring_credit.start.models.History;
import com.spring_credit.start.services.ServiceImpls.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class HistoryController {

    @Autowired
    HistoryServiceImpl historyService;

    @PostMapping("/addHistory")
    public History addHistory(@RequestBody History history){
        Random rd = new Random();
        Long idG= (long) (rd.nextDouble() * 199999999L);
        history.setId(idG);
        return historyService.saveHistory(history);
    }



    @GetMapping("/histories")
    public List<History> findAllHistories(){
       return  historyService.getHistories();
    }
}
