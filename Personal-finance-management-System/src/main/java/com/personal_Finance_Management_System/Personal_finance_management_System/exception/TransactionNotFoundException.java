package com.personal_Finance_Management_System.Personal_finance_management_System.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String message) {
        super(message);
    }
}

