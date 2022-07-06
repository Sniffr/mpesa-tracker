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
            moneyRequestService.processMoneyRequest(request);
            return "Transaction Saved Successfully";
        } catch (Exception e) {
            log.error("Error saving money requests", e);
            return null;
        }
    }
    //controller to get all money requests
    @GetMapping("/money/all")
    public List<Transaction> getAllMoneyRequests() {
        try {
            return moneyRequestService.getAllMoneyRequests();
        } catch (Exception e) {
            log.error("Error getting all money requests", e);
            return null;
        }
    }
    //controller to get all recepients
    @GetMapping("/money/senders")
    public List<Recepient> getAllRecepients() {
        try {
            return moneyRequestService.getAllRecepients();
        } catch (Exception e) {
            log.error("Error getting all sender requests", e);
            return null;
        }
    }
}
