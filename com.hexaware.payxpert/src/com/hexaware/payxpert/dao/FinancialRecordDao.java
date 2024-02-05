
package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.payxpert.model.FinancialRecord;

import com.hexaware.payxpert.util.DatabaseContext;

public class FinancialRecordDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public FinancialRecordDao() {
        con = DatabaseContext.getDBConn();
    }

 
 // Assume this is initialized elsewhere

    // Constructor or injection method for initializing the connection
    public FinancialRecordDao(Connection con) {
        this.con = con;
    }

    public List<FinancialRecord> getFinancialRecordById(int recordID) {
        List<FinancialRecord> financialRecords = new ArrayList<>();

        try {
            // Using a PreparedStatement to avoid SQL injection
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FinancialRecord WHERE recordID = ?");
            preparedStatement.setInt(1, recordID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                FinancialRecord financialRecord = new FinancialRecord();
                // Set financial record details from ResultSet
                financialRecord.setRecordID(rs.getInt("recordID"));
                financialRecord.setEmployeeID(rs.getInt("employeeID"));
                financialRecord.setRecordDate(rs.getString("recordDate"));
                financialRecord.setDescription(rs.getString("descriptions"));
                financialRecord.setAmount(rs.getDouble("amount"));
                financialRecord.setRecordType(rs.getString("recordType"));

                // Add financial record to the list
                financialRecords.add(financialRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return financialRecords;
    }
    public List<FinancialRecord> getFinancialRecordByEmployeeId(int employeeId) {
        List<FinancialRecord> financialRecords = new ArrayList<>();

        try {
            // Using a PreparedStatement to avoid SQL injection
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FinancialRecord WHERE employeeId = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                FinancialRecord financialRecord = new FinancialRecord();
                // Set financial record details from ResultSet
                financialRecord.setRecordID(rs.getInt("recordID"));
                financialRecord.setEmployeeID(rs.getInt("employeeID"));
                financialRecord.setRecordDate(rs.getString("recordDate"));
                financialRecord.setDescription(rs.getString("descriptions"));
                financialRecord.setAmount(rs.getDouble("amount"));
                financialRecord.setRecordType(rs.getString("recordType"));

                
                
                // Add financial record to the list
                financialRecords.add(financialRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return financialRecords;
    }
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            // Connection should not be closed in the middle. It should be managed by the application or a connection pool.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}