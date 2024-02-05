package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.dao.FinancialRecordDao;
import com.hexaware.payxpert.model.FinancialRecord;

public class FinancialRecordService implements IFinancialRecordService {
    private FinancialRecordDao financialRecordDao;

    public FinancialRecordService() {
        // Initialize the financialRecordDao as needed, e.g., by creating an instance of FinancialRecordDao
        financialRecordDao = new FinancialRecordDao();
    }

    public FinancialRecordService(FinancialRecordDao financialRecordDao) {
        this.financialRecordDao = financialRecordDao;
    }

    public void printFinancialRecordsById(int recordID) {
        List<FinancialRecord> financialRecords = getFinancialRecordsById(recordID);

        if (!financialRecords.isEmpty()) {
            System.out.println("Financial Records for Record ID " + recordID + ":");
            for (FinancialRecord financialRecord : financialRecords) {
                System.out.println("Record ID: " + financialRecord.getRecordID());
                System.out.println("Employee ID: " + financialRecord.getEmployeeID());
                System.out.println("Record Date: " + financialRecord.getRecordDate());
                System.out.println("Description: " + financialRecord.getDescription());
                System.out.println("Amount: " + financialRecord.getAmount());
                System.out.println("Record Type: " + financialRecord.getRecordType());
                System.out.println();
            }
        } else {
            System.out.println("No financial records found for Record ID " + recordID);
        }
    }

    private List<FinancialRecord> getFinancialRecordsById(int recordID) {
        return financialRecordDao.getFinancialRecordById(recordID);
    }
    
    
    
    public void printFinancialRecordsByEmployeeId(int employeeId) {
        List<FinancialRecord> financialRecords = getFinancialRecordByEmployeeId(employeeId);

        if (!financialRecords.isEmpty()) {
            System.out.println("Financial Records for Record ID " + employeeId + ":");
            for (FinancialRecord financialRecord : financialRecords) {
                System.out.println("Record ID: " + financialRecord.getRecordID());
                System.out.println("Employee ID: " + financialRecord.getEmployeeID());
                System.out.println("Record Date: " + financialRecord.getRecordDate());
                System.out.println("Description: " + financialRecord.getDescription());
                System.out.println("Amount: " + financialRecord.getAmount());
                System.out.println("Record Type: " + financialRecord.getRecordType());
                System.out.println();
            }
        } else {
            System.out.println("No financial records found for Record ID " + employeeId);
        }
    }

    private List<FinancialRecord> getFinancialRecordByEmployeeId(int employeeId) {
        return financialRecordDao.getFinancialRecordByEmployeeId(employeeId);
    }
}