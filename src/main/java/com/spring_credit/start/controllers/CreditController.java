package com.spring_credit.start.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.spring_credit.start.services.ServiceImpls.CreditServiceImpl;
import com.spring_credit.start.models.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class CreditController {

    @Autowired
    CreditServiceImpl creditServiceImpl;

    @GetMapping("/credits")
    public List<Credit> getAllCredits(){
        return creditServiceImpl.getCredits();
    }
    @PostMapping("/saveCr")
    public Credit addCredit(@RequestBody Credit credit){
        Random rd = new Random();
        Long idG= (long) (rd.nextDouble() * 199999999L);
        credit.setId(idG);
        return creditServiceImpl.saveCredit(credit);

    }

    //@GetMapping("/calculCredit?amount={amount}&creditTerm={creditTerm}&taux={taux}")
    @RequestMapping(path = "/calculCredit/amount={amount}/creditTerm={creditTerm}/taux={taux}", method = RequestMethod.GET)
    public String creditCalcul(@PathVariable double amount, @PathVariable int creditTerm, @PathVariable double taux ){
        System.out.print(amount+""+creditTerm+""+taux);
        return  creditServiceImpl.calculCredit(amount,creditTerm,taux);
    }

}
