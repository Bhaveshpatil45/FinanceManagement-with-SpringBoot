package com.personal_Finance_Management_System.Personal_finance_management_System.service;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Budget;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.exception.BudgetNotFoundException;
import com.personal_Finance_Management_System.Personal_finance_management_System.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUser(User user) {
        return budgetRepository.findByUser(user);
    }

    public List<Budget> getBudgetsByUserAndMonth(User user, YearMonth monthYear) {
        return budgetRepository.findByUserAndMonthYear(user, monthYear);
    }

    public Budget updateBudget(Long budgetId, Budget updatedBudget) {
        Budget existingBudget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new BudgetNotFoundException("Budget with ID " + budgetId + " not found"));

        existingBudget.setCategory(updatedBudget.getCategory());
        existingBudget.setAmount(updatedBudget.getAmount());
        existingBudget.setMonthYear(updatedBudget.getMonthYear());
        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long budgetId) {
        if (!budgetRepository.existsById(budgetId)) {
            throw new BudgetNotFoundException("Budget with ID " + budgetId + " not found");
        }
        budgetRepository.deleteById(budgetId);
    }
}

