package com.spring_credit.start.services.ServiceImpls;

import com.spring_credit.start.models.Client;
import com.spring_credit.start.repositories.ClientRepository;
import com.spring_credit.start.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public String saveClient(Client client) {

        this.clientRepository.save(client);
        return "client added";
    }

    @Override
    public void sendMail(String to) throws MessagingException, IOException {

        System.out.print("Email sending ........");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testkarbal@gmail.com", "Youcode2021");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("testkarbal@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Credit");
        msg.setContent("Hello Dear, your credit is accepted", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Hello Dear, your credit is accepted", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);
        System.out.println("Email sent");
    }


    public String findByMail(String email) {
        String user = clientRepository.findByEmail(email);
        if(user==null) System.out.println("user not Found"); else System.out.println(user) ;

        return null;
    }

}
