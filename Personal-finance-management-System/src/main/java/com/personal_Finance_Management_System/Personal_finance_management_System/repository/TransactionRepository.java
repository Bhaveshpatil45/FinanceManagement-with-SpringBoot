package com.personal_Finance_Management_System.Personal_finance_management_System.repository;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Transaction;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
    List<Transaction> findByUserAndCategory(User user, String category);
}

