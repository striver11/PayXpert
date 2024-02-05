package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.payxpert.model.Employee;
import com.hexaware.payxpert.util.DatabaseContext;
import com.hexaware.payxpert.model.Payroll;

public class PayrollDao {
	 Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    
	    public void createPayroll(Payroll payroll) {
	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement(
	                    "INSERT INTO payroll (employeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, otherpay, Deductions) VALUES (?, ?, ?, ?, ?, ?, ?)");

	            ps.setInt(1, payroll.getEmployeeID());
	            ps.setDate(2, new java.sql.Date(payroll.getPayPeriodStartDate().getTime()));
	            ps.setDate(3, new java.sql.Date(payroll.getPayPeriodEndDate().getTime()));
	            ps.setDouble(4, payroll.getBasicSalary());
	            ps.setDouble(5, payroll.getOvertimePay());
	            ps.setDouble(6, payroll.getOtherPay());
	            ps.setDouble(7, payroll.getDeductions());

	            int noOfRows = ps.executeUpdate();
	            System.out.println(noOfRows + " payroll record inserted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	    }
	    
	    
	    public Payroll getPayrollById(int payrollId) {
	        Payroll payroll = null;
	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM payroll WHERE payrollID = ?");
	            ps.setInt(1, payrollId);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                // Populate the Payroll object
	                payroll = new Payroll(
	                        rs.getInt("employeeID"),
	                        rs.getDate("PayPeriodStartDate"),
	                        rs.getDate("PayPeriodEndDate"),
	                        rs.getDouble("BasicSalary"),
	                        rs.getDouble("OvertimePay"),
	                        rs.getDouble("otherPay"),
	                        rs.getDouble("deductions")
	                        
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return payroll;
	    }
	    
	    public List<Payroll> getPayrollsForEmployee(int employeeId) {
	        List<Payroll> payrolls = new ArrayList<>();

	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM payroll WHERE employeeID = ?");
	            ps.setInt(1, employeeId);

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Payroll payroll = new Payroll();
	                // Set payroll details from ResultSet
	                payroll.setPayrollID(rs.getInt("payrollID"));
	                payroll.setEmployeeID(rs.getInt("employeeID"));
	                payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	                payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	                payroll.setBasicSalary(rs.getDouble("BasicSalary"));
	                payroll.setOvertimePay(rs.getDouble("overtimePay"));
	                payroll.setOtherPay(rs.getDouble("otherPay"));
	                payroll.setDeductions(rs.getDouble("deductions"));

	                // Add payroll to the list
	                payrolls.add(payroll);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return payrolls;
	    }
	    
	    
	    public List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod) {
	        List<Payroll> payrolls = new ArrayList<>();

	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement(
	                    "SELECT * FROM payroll WHERE PayPeriodStartDate >= ? AND PayPeriodEndDate <= ?");

	            ps.setDate(1, Date.valueOf(startPeriod));
	            ps.setDate(2, Date.valueOf(endPeriod));

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Payroll payroll = new Payroll();
	                // Set payroll details from the result set
	                payroll.setPayrollID(rs.getInt("payrollID"));
	                payroll.setEmployeeID(rs.getInt("employeeID"));
	                payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	                payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	                payroll.setBasicSalary(rs.getDouble("BasicSalary"));
	                payroll.setOvertimePay(rs.getDouble("overtimePay"));
	                payroll.setOtherPay(rs.getDouble("otherPay"));
	                payroll.setDeductions(rs.getDouble("deductions"));

	                payrolls.add(payroll);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return payrolls;
	    }

	    private void closeResources() {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
