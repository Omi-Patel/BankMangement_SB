package com.ompatel.bankManagement.services;

import com.ompatel.bankManagement.model.Account;
import com.ompatel.bankManagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository repo;


    public List<Account> getAllAccounts() {
        return repo.findAll();
    }


    public ResponseEntity<Account> createAccount(Account account) {
        Account newAccount = repo.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    public Account getAccountById(Long accountNumber) {
        return repo.findById(accountNumber).get();
    }


    public Account depositAmount(Long accountNumber, Double amount) {
        Account existingAccount = repo.findById(accountNumber).get();

        existingAccount.setBalance(existingAccount.getBalance() + amount);
        repo.save(existingAccount);

        return existingAccount;
    }

    public Account withdrawAmount(Long accountNumber, Double amount) {
        Account existingAccount = repo.findById(accountNumber).get();

        existingAccount.setBalance(existingAccount.getBalance() - amount);
        repo.save(existingAccount);

        return existingAccount;
    }

    public ResponseEntity<String> closeAccount(Long accountNumber) {
        repo.deleteById(accountNumber);
        return ResponseEntity.status(HttpStatus.OK).body("Account Closed!!");
    }
}
