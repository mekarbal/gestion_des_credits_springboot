package com.spring_credit.start.services;

import com.spring_credit.start.models.Client;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface ClientService {

    public List<Client> getAll();
    public String saveClient(Client client);
    public void sendMail(String to) throws MessagingException, IOException;
   // public void findByMail(String email);
}
