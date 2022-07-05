package com.cryptochain.movies.controller.money;

import com.cryptochain.movies.service.money.MoneyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyController {
    @Autowired
    MoneyRequestService moneyRequestService;
    @PostMapping("/money")
    public void MoneyRequest(@RequestBody String request) {
        moneyRequestService.processMoneyRequest(request);
    }
}
