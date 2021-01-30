package com.spring_credit.start.services.ServiceImpls;

import com.spring_credit.start.models.Credit;
import com.spring_credit.start.repositories.CreditRepository;
import com.spring_credit.start.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository creditRepository;

    @Override
    public List<Credit> getCredits() {
        return creditRepository.findAll();
    }

    @Override
    public String calculCredit(double amount, int creditTerm, double taux) {


        double amountMonth=(amount*taux*Math.pow((1+taux),creditTerm*12))/Math.pow((1+taux),creditTerm*12);

        return "le montant mensuelle "+amount+" "+amountMonth;
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}
