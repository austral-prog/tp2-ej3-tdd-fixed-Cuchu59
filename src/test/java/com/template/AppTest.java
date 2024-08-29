package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.deposit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Soldado Ruso", 100);
        Map<String, Integer> updatedAccounts = deposit(accounts, "Soldado Ruso", 75);

        
        assertEquals(175, updatedAccounts.get("Soldado Ruso"));
    }
    
    @Test
    void testNegativeDeposit() {
        Map<String, Integer> accounts = new HashMap<>();

        accounts.put("Pepo", 100);
        Map<String, Integer> updatedAccounts = deposit(accounts, "Pepo", -35);
        
        assertEquals(100, updatedAccounts.get("Pepo"));
    }
    
    @Test
    void testDespositNotAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Pepo", 100);
        Map<String, Integer> updatedAccounts = deposit(accounts, "Fantasma", 20);
        
        assertEquals(null, updatedAccounts.get("Fantasma"));
    }

    @Test
    void testWithdraw() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Soldado Ruso", 100);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Soldado Ruso", 75);

        
        assertEquals(25, updatedAccounts.get("Soldado Ruso"));
    }
    
    @Test
    void testWithdrawNegativeDeposit() {
        Map<String, Integer> accounts = new HashMap<>();

        accounts.put("Pepo", 100);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Pepo", -35);
        
        assertEquals(100, updatedAccounts.get("Pepo"));
    }
    
    @Test
    void testWithdrawNotAccount() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Pepo", 100);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Fantasma", 20);
        
        assertEquals(null, updatedAccounts.get("Fantasma"));
    }

    @Test
    void notMoneyTest() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Mi Hermanito", 0);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Mi Hermanito", 20);
        
            assertEquals(0, updatedAccounts.get("Mi Hermanito"));
    }
    
    @Test
    void testTransfer() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Jaime", 20);
        accounts.put("Luis", 0);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Jaime", 20, "Luis");
        
        assertEquals(20, updatedAccounts.get("Luis"));
        assertEquals(0, updatedAccounts.get("Jaime"));
        
    }
    
    @Test
    void testTransfer_noMoney() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Jaime", 0);
        accounts.put("Luis", 0);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Jaime", 20, "Luis");
        
        assertEquals(0, updatedAccounts.get("Luis"));
        assertEquals(0, updatedAccounts.get("Jaime"));
        
    }

    @Test
    void testTransfer_ghosts() {
        Map<String, Integer> accounts = new HashMap<>();
        
        Map<String, Integer> updatedAccounts = transfer(accounts, "Jaime", 20, "Luis");
        
        assertEquals(null, updatedAccounts.get("Luis"));
        assertEquals(null, updatedAccounts.get("Jaime"));
        
    }

    @Test
    void testTransfer_negative() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Jaime", 20);
        accounts.put("Luis", 0);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Jaime", -20, "Luis");
        
        assertEquals(0, updatedAccounts.get("Luis"));
        assertEquals(20, updatedAccounts.get("Jaime"));
        
    }

    @Test
    void testTransfer_toME() {
        Map<String, Integer> accounts = new HashMap<>();
        
        accounts.put("Luis", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "Luis", 5, "Luis");
        
        assertEquals(20, updatedAccounts.get("Luis"));
        
    }

    @Test
    void nullMap_dep() {
        Map<String, Integer> accounts = new HashMap<>();
        
        Map<String, Integer> updatedAccounts = deposit(accounts, "Jaime", 20);
        
        assertEquals(accounts, updatedAccounts);
        
    }

    @Test
    void nullMap_withdraw() {
        Map<String, Integer> accounts = new HashMap<>();
        
        Map<String, Integer> updatedAccounts = withdraw(accounts, "Jaime", 20);
        
        assertEquals(accounts, updatedAccounts);
        
    }

    @Test
    void nullMap_transfer() {
        Map<String, Integer> accounts = new HashMap<>();
        
        Map<String, Integer> updatedAccounts = transfer(accounts, "Jaime", 20, "");
        
        assertEquals(accounts, updatedAccounts);
        
    }
}
