package com.hexaware.payxpert.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidationService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void validateAlphabets(String input) {
        if (!input.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Only alphabets are allowed.");
            System.exit(1);
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
            System.out.println("Invalid phone number format. Please use xxx-xxx-xxxx.");
            System.exit(1);
        }
    }

    public static Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            System.exit(1);
            return null; // Unreachable code, added to satisfy the compiler
        }
    }
}
