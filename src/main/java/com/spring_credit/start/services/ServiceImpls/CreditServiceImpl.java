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
    public double calculCredit(double amount, double taux) {

        double interest=amount*taux;
        System.out.println(interest+amount);
        return interest+amount;
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}
