package com.personal_Finance_Management_System.Personal_finance_management_System.service;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Transaction;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.exception.TransactionNotFoundException;
import com.personal_Finance_Management_System.Personal_finance_management_System.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public List<Transaction> getTransactionsByCategory(User user, String category) {
        return transactionRepository.findByUserAndCategory(user, category);
    }

    public void deleteTransaction(Long transactionId) {
        if (!transactionRepository.existsById(transactionId)) {
            throw new TransactionNotFoundException("Transaction not found");
        }
        transactionRepository.deleteById(transactionId);
    }
}

