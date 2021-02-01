package com.spring_credit.start.services.ServiceImpls;

import com.spring_credit.start.models.History;
import com.spring_credit.start.repositories.HistoryRespository;
import com.spring_credit.start.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRespository historyRespository;

    public History saveHistory(@RequestBody History history){
        return  historyRespository.save(history);
    }

    public List<History> getHistories(){
        return  historyRespository.findAll();
    }
}
