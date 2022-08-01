package com.cryptochain.movies.controller.money;

import com.cryptochain.movies.entities.Money.Recepient;
import com.cryptochain.movies.entities.Money.Transaction;
import com.cryptochain.movies.service.money.MoneyRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MoneyController {
    @Autowired
    MoneyRequestService moneyRequestService;

    @PostMapping("/money")
    public String MoneyRequest(@RequestBody String request) {
        try {
            return moneyRequestService.processMoneyRequest(request).toString();

        } catch (Exception e) {
            log.error("Error saving money requests", e);
            throw new RuntimeException("Error saving request");
        }
    }

    //controller to get all money requests
    @GetMapping("/money/all")
    public List<Transaction> getAllMoneyRequests() {
        try {
            return moneyRequestService.getAllMoneyRequests();
        } catch (Exception e) {
            log.error("Error getting all money requests", e);
            throw new RuntimeException("Error getting all transaction requests");
        }
    }

    //controller to get all recepients
    @GetMapping("/money/senders")
    public List<Recepient> getAllRecepients() {
        try {
            return moneyRequestService.getAllRecepients();
        } catch (Exception e) {
            log.error("Error getting all sender requests", e);
            //throw new RuntimeException() with message "Error getting all sender requests"
            throw new RuntimeException("Error getting all sender requests");

        }
    }
    //modify sender  to add description
    @PostMapping("/money/sender/")
    public Recepient modifyRecepient(@RequestBody Recepient recepient) {
        try {
            return moneyRequestService.modifyRecepient(recepient);
        } catch (Exception e) {
            log.error("Error getting all sender requests", e);
            //throw new RuntimeException() with message "Error getting all sender requests"
            throw new RuntimeException("Error getting all sender requests");

        }
    }

    //controller to get all null description recepients
    @GetMapping("/money/senders/null")
    public List<Recepient> getAllNullDescriptionRecepients() {
        try {
            return moneyRequestService.getAllRecepientsWithNullDescription();
        } catch (Exception e) {
            log.error("Error getting all null description recepients", e);
            //throw new RuntimeException() with message "Error getting all null description recepients"
            throw new RuntimeException("Error getting all null description recepients");

        }
    }
    //post mapp
}
