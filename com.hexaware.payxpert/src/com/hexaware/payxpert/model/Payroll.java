package com.hexaware.payxpert.model;

import java.util.Date;

public class Payroll {
    private int payrollID;
    private int employeeID;
    private Date payPeriodStartDate;
    private Date payPeriodEndDate;
    private double basicSalary;
    private double overtimePay;
    private double otherPay;
    private double deductions;
    private double grossSalary;
    private double taxAmount;
    private double netSalary;

    // Constructors
    public Payroll() {
        // Default constructor
    }

    public Payroll(int payrollID, int employeeID, Date payPeriodStartDate, Date payPeriodEndDate,
                   double basicSalary, double overtimePay, double otherPay, double deductions,
                   double grossSalary, double taxAmount, double netSalary) {
        this.payrollID = payrollID;
        this.employeeID = employeeID;
        this.payPeriodStartDate = payPeriodStartDate;
        this.payPeriodEndDate = payPeriodEndDate;
        this.basicSalary = basicSalary;
        this.overtimePay = overtimePay;
        this.otherPay = otherPay;
        this.deductions = deductions;
        this.grossSalary = grossSalary;
        this.taxAmount = taxAmount;
        this.netSalary = netSalary;
    }

    public Payroll(int employeeID, Date payPeriodStartDate, Date payPeriodEndDate,
            double basicSalary, double overtimePay, double otherPay, double deductions) {
 this.employeeID = employeeID;
 this.payPeriodStartDate = payPeriodStartDate;
 this.payPeriodEndDate = payPeriodEndDate;
 this.basicSalary = basicSalary;
 this.overtimePay = overtimePay;
 this.otherPay = otherPay;
 this.deductions = deductions;
}

    public int getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(int payrollID) {
        this.payrollID = payrollID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public void setPayPeriodStartDate(Date payPeriodStartDate) {
        this.payPeriodStartDate = payPeriodStartDate;
    }

    public Date getPayPeriodEndDate() {
        return payPeriodEndDate;
    }

    public void setPayPeriodEndDate(Date payPeriodEndDate) {
        this.payPeriodEndDate = payPeriodEndDate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public double getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(double otherPay) {
        this.otherPay = otherPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollID=" + payrollID +
                ", employeeID=" + employeeID +
                ", payPeriodStartDate=" + payPeriodStartDate +
                ", payPeriodEndDate=" + payPeriodEndDate +
                ", basicSalary=" + basicSalary +
                ", overtimePay=" + overtimePay +
                ", otherPay=" + otherPay +
                ", deductions=" + deductions +
                ", grossSalary=" + grossSalary +
                ", taxAmount=" + taxAmount +
                ", netSalary=" + netSalary +
                '}';
    }
}
