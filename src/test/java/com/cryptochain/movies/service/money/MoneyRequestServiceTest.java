package com.cryptochain.movies.service.money;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MoneyRequestServiceTest {

    @Test
    void processMoneyRequest() {
        String moneyString = "QG25RFDH03 Confirmed. Ksh800.00 paid to ZEN GARDEN. on 2/7/22 at 8:44 PM.New M-PESA balance is Ksh3,884.43. Transaction cost, Ksh0.00. Amount you can transact within the day is 285,040.00.You can now access M-PESA via *334#";
        //Extract substring of lineOfCurrencies by using a regular expression
        Pattern pat = Pattern.compile("(?<=to).*?(?=\\.)");

        Matcher mat = pat.matcher(moneyString);
        while (mat.find())
            System.out.println("Match: " + mat.group());
    }

    @Test
    void processMoneyRequest2() {
        String moneyString = "QG24RJGXD6 Confirmed. Ksh500.00 sent to CHARLES  MACHARIA MAINGI 0721477040 on 2/7/22 at 9:37 PM. New M-PESA balance is Ksh3,378.43. Transaction cost, Ksh6.00. Amount you can transact within the day is 284,540.00. Get Stamped M-PESA Statement for free, dial *334# >My Account>M-PESA statement. To reverse, forward this message to 456.";
        Pattern pat = Pattern.compile("(?<=to).*?(?=[0-9])");

        Matcher mat = pat.matcher(moneyString);

        while (mat.find())
            System.out.println("Match: " + mat.group());

    }

}