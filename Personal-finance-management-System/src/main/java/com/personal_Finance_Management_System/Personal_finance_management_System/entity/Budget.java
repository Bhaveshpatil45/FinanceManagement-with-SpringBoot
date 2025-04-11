package com.personal_Finance_Management_System.Personal_finance_management_System.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.YearMonth;

public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private YearMonth monthYear;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Budget() {}

    public Budget(Long id, String category, Double amount, YearMonth monthYear, User user) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.monthYear = monthYear;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public YearMonth getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(YearMonth monthYear) {
        this.monthYear = monthYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
