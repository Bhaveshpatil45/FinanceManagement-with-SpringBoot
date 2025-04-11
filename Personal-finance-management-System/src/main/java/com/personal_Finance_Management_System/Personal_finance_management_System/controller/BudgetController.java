package com.personal_Finance_Management_System.Personal_finance_management_System.controller;

import com.personal_Finance_Management_System.Personal_finance_management_System.entity.Budget;
import com.personal_Finance_Management_System.Personal_finance_management_System.entity.User;
import com.personal_Finance_Management_System.Personal_finance_management_System.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public Budget addBudget(@RequestBody Budget budget, Principal principal) {
        User user = getUserFromPrincipal(principal);
        budget.setUser(user);
        return budgetService.addBudget(budget);
    }

    @GetMapping
    public List<Budget> getBudgets(Principal principal) {
        User user = getUserFromPrincipal(principal);
        return budgetService.getBudgetsByUser(user);
    }

    @GetMapping("/{monthYear}")
    public List<Budget> getBudgetsByMonth(@PathVariable String monthYear, Principal principal) {
        User user = getUserFromPrincipal(principal);
        YearMonth yearMonth = YearMonth.parse(monthYear);
        return budgetService.getBudgetsByUserAndMonth(user, yearMonth);
    }

    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.updateBudget(id, budget);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

    private User getUserFromPrincipal(Principal principal) {
        // Mock logic to get User; Replace with actual logic (e.g., fetching user from DB)
        return new User(principal.getName(), "", "", "");
    }
}

