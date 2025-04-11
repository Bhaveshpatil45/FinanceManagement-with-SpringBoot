package com.personal_Finance_Management_System.Personal_finance_management_System.repository;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Budget;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import java.time.YearMonth;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserAndMonthYear(User user, YearMonth monthYear);
    List<Budget> findByUser(User user);
}

