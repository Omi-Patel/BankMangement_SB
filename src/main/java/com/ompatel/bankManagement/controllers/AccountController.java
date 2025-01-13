package com.ompatel.bankManagement.controllers;

import com.ompatel.bankManagement.model.Account;
import com.ompatel.bankManagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping
    public List<Account> getAllAccounts(){
        return service.getAllAccounts();
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return service.createAccount(account);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountById(@PathVariable Long accountNumber){
        return service.getAccountById(accountNumber);
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.depositAmount(accountNumber, amount);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.withdrawAmount(accountNumber, amount);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber){
        return service.closeAccount(accountNumber);
    }
}
