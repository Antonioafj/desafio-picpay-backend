package com.desafio_picpay.services;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dtos.TransactionDTO;
import com.desafio_picpay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        if()

    }

    public boolean authorizeTransaction(User sender, BigDecimal value){
       ResponseEntity<Map> autorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

       if (autorizationResponse.getStatusCode() == HttpStatus.OK){
           String message = (String) autorizationResponse.getBody().get("message");
           return "Autorizado".equalsIgnoreCase(message);
       }else return false;
    }
}

































