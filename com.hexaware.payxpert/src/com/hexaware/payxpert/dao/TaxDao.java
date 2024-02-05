package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.payxpert.model.Tax;
import com.hexaware.payxpert.util.DatabaseContext;

public class TaxDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public TaxDao() {
        con = DatabaseContext.getDBConn();
    }

    public List<Tax> getTaxesById(int taxId) {
        List<Tax> taxes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM tax WHERE taxId = ?");
            preparedStatement.setInt(1, taxId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Tax tax = new Tax();
                // Set tax details from ResultSet
                tax.setTaxID(rs.getInt("taxId"));
                tax.setEmployeeID(rs.getInt("employeeID"));
                tax.setTaxYear(rs.getInt("taxYear"));
                tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                tax.setTaxAmount(rs.getDouble("taxAmount"));

                // Add tax to the list
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return taxes;
    }
    public List<Tax> getTaxesByEmployeeId(int employeeId) {
        List<Tax> taxes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM tax WHERE employeeID = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Tax tax = new Tax();
               
                tax.setTaxID(rs.getInt("taxId"));
                tax.setEmployeeID(rs.getInt("employeeID"));
                tax.setTaxYear(rs.getInt("taxYear"));
                tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                tax.setTaxAmount(rs.getDouble("taxAmount"));

                // Add tax to the list
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taxes;
    }
    
    public List<Tax> getTaxesByTaxYear(int taxYear) {
        List<Tax> taxes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM tax WHERE TaxYear = ?");
            preparedStatement.setInt(1, taxYear);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Tax tax = new Tax();
                // Set tax details from ResultSet
                tax.setTaxID(rs.getInt("taxId"));
                tax.setEmployeeID(rs.getInt("employeeID"));
                tax.setTaxYear(rs.getInt("taxYear"));
                tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                tax.setTaxAmount(rs.getDouble("taxAmount"));

                // Add tax to the list
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taxes;
    }

    // Other methods...

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
