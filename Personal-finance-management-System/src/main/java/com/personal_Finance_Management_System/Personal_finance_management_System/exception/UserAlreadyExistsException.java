package com.personal_Finance_Management_System.Personal_finance_management_System.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

