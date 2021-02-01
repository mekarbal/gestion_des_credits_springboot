package com.spring_credit.start.controllers;

import com.spring_credit.start.models.Client;
import com.spring_credit.start.services.ServiceImpls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;



@RestController
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping("/getAllClients")
    public List<Client> getClients(){
        return clientService.getAll();
    }



    @PostMapping("/save")
    public String save(@RequestBody Client client){
        Random rd = new Random();
         Long idG= (long) (rd.nextDouble() * 199999999L);
         client.setId(idG);
         String newClient= clientService.saveClient(client);
          return newClient;
    }

    @PostMapping("/send")
    public void Mail() throws IOException, MessagingException {
        clientService.sendMail("mh.karbal@gmail.com");
    }

    @GetMapping("/getuser")
    public void getUserByEmail(@RequestBody String email){
        clientService.findByMail(email);
    }

}
