package com.spring_credit.start.services;

import com.spring_credit.start.models.Credit;

import java.util.List;

public interface CreditService {
    public List<Credit> getCredits();
    public String calculCredit(double amount,int creditTerm,double taux);
    public Credit saveCredit(Credit credit);

}
