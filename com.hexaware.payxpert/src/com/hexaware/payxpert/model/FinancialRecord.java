package com.hexaware.payxpert.model;



public class FinancialRecord {
    private int recordID;
    private int employeeID;
    private String recordDate;
    private String description;
    private double amount;
    private String recordType;

    // Constructors
    public FinancialRecord() {
        // Default constructor
    }

    public FinancialRecord(int recordID, int employeeID, String recordDate, String description, double amount, String recordType) {
        this.recordID = recordID;
        this.employeeID = employeeID;
        this.recordDate = recordDate;
        this.description = description;
        this.amount = amount;
        this.recordType = recordType;
    }


    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "FinancialRecord{" +
                "recordID=" + recordID +
                ", employeeID=" + employeeID +
                ", recordDate='" + recordDate + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", recordType='" + recordType + '\'' +
                '}';
    }
}

