package com.cryptochain.movies.service.money;

import com.cryptochain.movies.entities.Money.Recepient;
import com.cryptochain.movies.entities.Money.Transaction;
import com.cryptochain.movies.repository.RecepientRepository;
import com.cryptochain.movies.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MoneyRequestService {
    //autowire transactionRepository
//autowire recepientRepository
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RecepientRepository recepientRepository;

    public boolean requestDesirialize(String request) {
        return request.contains("sent") || request.contains("paid");
    }

    public Map<String, String> extractMoneyRequest(String request) {
        Map<String, String> extractedMoneyRequest = new HashMap<>();
        Pattern buyGoodsPat = Pattern.compile("(?<=to).*?(?=\\.)");
        Pattern sendMoneyPat = Pattern.compile("(?<=to).*?(?=[0-9])");
        //make two new patters called transactionIdpat and amountPat
        Pattern transactionIdPat = Pattern.compile("[A-Z][A-Z0-9]{9}");
        Pattern amountPat = Pattern.compile("(Ksh)(.+)\\.00\\s{1}");
        //match and extract
        if (request.contains("paid")) {
            Matcher mat = buyGoodsPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("recipient", mat.group());
            mat = transactionIdPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("transactionId", mat.group());
            mat = amountPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("amount", mat.group(2));
        } else if (request.contains("sent")) {
            Matcher mat = sendMoneyPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("recipient", mat.group());
            mat = transactionIdPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("transactionId", mat.group());
            mat = amountPat.matcher(request);
            if (mat.find())
                extractedMoneyRequest.put("amount", mat.group(2));
        } else {
            extractedMoneyRequest = null;
        }


        return extractedMoneyRequest;
    }

    //main function for saving transactions
    public void processMoneyRequest(String request) {
        if (requestDesirialize(request)) {
            Map<String, String> result = extractMoneyRequest(request);
            System.out.println(result);
            Recepient recepient = recepientRepository.findByName(result.get("recipient"));

            if (recepient == null) {
                recepient = Recepient.builder()
                        .name(result.get("recipient"))
                        .totalSpent(0L)
                        .build();
            }
            //since recipient is not null,we change its totalSpent to include the amount of the transaction
            recepient.setTotalSpent(recepient.getTotalSpent() + Long.parseLong(result.get("amount")));
            //save transaction using values from result
            Transaction transaction = Transaction.builder()
                    .amount(result.get("amount"))
                    .recipient(result.get("recipient"))
                    .transactionId(result.get("transactionId"))
                    .recepient(recepient)
                    .build();
            recepientRepository.save(recepient);
            transactionRepository.save(transaction);

        } else {
            System.out.println("Invalid request");
        }
    }


    public List<Transaction> getAllMoneyRequests() {
        return transactionRepository.findAll();
    }

    public List<Recepient> getAllRecepients() {
        return recepientRepository.findAll();
    }
}
