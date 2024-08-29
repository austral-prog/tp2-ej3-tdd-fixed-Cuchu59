package com.template;

import java.util.Collections;
import java.util.Map;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if(accounts != null && accounts.containsKey(account)) {
            int new_amount = accounts.get(account) + amount;
            if(amount < 0) { return accounts; }
            accounts.replace(account, new_amount);

        }
        return accounts;
    }

    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
     
        if(accounts != null &&accounts.containsKey(account)) {
            if(amount <= 0 || accounts.get(account) < amount ) { return accounts; }
            
            int new_amount = accounts.get(account) - amount;
            accounts.replace(account, new_amount);

        }
        return accounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String user_1, int amount, String user_2) {
        
        if(accounts == null || !(accounts.containsKey(user_1)) || !(accounts.containsKey(user_2)) || accounts.get(user_1) < amount || amount < 0) { return accounts; }

        accounts.replace(user_1, accounts.get(user_1) - amount);
        accounts.replace(user_2, accounts.get(user_2) + amount);

        return accounts;
    }


}
