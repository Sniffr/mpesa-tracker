package com.cryptochain.movies.controller.money;

import com.cryptochain.movies.entities.Money.Recepient;
import com.cryptochain.movies.entities.Money.Transaction;
import com.cryptochain.movies.service.money.MoneyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoneyController {
    @Autowired
    MoneyRequestService moneyRequestService;
    @PostMapping("/money")
    public void MoneyRequest(@RequestBody String request) {
        moneyRequestService.processMoneyRequest(request);
    }
    //controller to get all money requests
    @GetMapping("/money/all")
    public List<Transaction> getAllMoneyRequests() {
        return moneyRequestService.getAllMoneyRequests();
    }
    //controller to get all recepients
    @GetMapping("/money/senders")
    public List<Recepient> getAllRecepients() {
        return moneyRequestService.getAllRecepients();
    }
}
