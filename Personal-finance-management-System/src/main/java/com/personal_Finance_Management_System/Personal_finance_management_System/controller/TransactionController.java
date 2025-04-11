package com.personal_Finance_Management_System.Personal_finance_management_System.controller;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Transaction;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.service.TransactionService;
import com.personal_Finance_Management_System.Personal_finance_management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        transaction.setUser(user);
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        return transactionService.getTransactionsByUser(user);
    }

    @GetMapping("/category/{category}")
    public List<Transaction> getTransactionsByCategory(@PathVariable String category, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        return transactionService.getTransactionsByCategory(user, category);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
