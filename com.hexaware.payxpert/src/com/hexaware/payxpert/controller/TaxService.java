package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.dao.TaxDao;
import com.hexaware.payxpert.model.Tax;

public class TaxService implements  ITaxService{
    private TaxDao taxDao;

    public TaxService() {
        // Initialize the taxDao as needed, e.g., by creating an instance of TaxDao
        taxDao = new TaxDao();
    }

    public TaxService(TaxDao taxDao) {
        this.taxDao = taxDao;
    }

    public void printTaxesById(int taxId) {
        List<Tax> taxes = getTaxesById(taxId);

        if (!taxes.isEmpty()) {
            System.out.println("Taxes for Tax ID " + taxId + ":");
            for (Tax tax : taxes) {
                System.out.println("Tax ID: " + tax.getTaxID());
                System.out.println("Employee ID: " + tax.getEmployeeID());
                System.out.println("Tax Year: " + tax.getTaxYear());
                System.out.println("Taxable Income: " + tax.getTaxableIncome());
                System.out.println("Tax Amount: " + tax.getTaxAmount());
                System.out.println();
             
            }
        } else {
            System.out.println("No taxes found for Tax ID " + taxId);
        }
    }

    private List<Tax> getTaxesById(int taxId) {
        return taxDao.getTaxesById(taxId);
    }
    
    
    
    public void printTaxesByEmployeeId(int customerId) {
        List<Tax> taxes = getTaxesByEmployeeId(customerId);

        if (!taxes.isEmpty()) {
            System.out.println("Taxes for Tax ID " + customerId + ":");
            for (Tax tax : taxes) {
                System.out.println("Tax ID: " + tax.getTaxID());
                System.out.println("Employee ID: " + tax.getEmployeeID());
                System.out.println("Tax Year: " + tax.getTaxYear());
                System.out.println("Taxable Income: " + tax.getTaxableIncome());
                System.out.println("Tax Amount: " + tax.getTaxAmount());
           System.out.println();
            }
        } else {
            System.out.println("No taxes found for Tax ID " + customerId);
        }
    }

    private List<Tax> getTaxesByEmployeeId(int customerId) {
        return taxDao.getTaxesByEmployeeId(customerId);
    }
    
    
    
    public void printTaxesByTaxYear(int taxYear) {
        List<Tax> taxes = getTaxesByTaxYear(taxYear);

        if (!taxes.isEmpty()) {
            System.out.println("Taxes for Tax ID " + taxYear + ":");
            for (Tax tax : taxes) {
                System.out.println("Tax ID: " + tax.getTaxID());
                System.out.println("Employee ID: " + tax.getEmployeeID());
                System.out.println("Tax Year: " + tax.getTaxYear());
                System.out.println("Taxable Income: " + tax.getTaxableIncome());
                System.out.println("Tax Amount: " + tax.getTaxAmount());
                System.out.println();
            }
        } else {
            System.out.println("No taxes found for Tax ID " + taxYear);
        }
    }

    private List<Tax> getTaxesByTaxYear(int taxYear) {
        return taxDao.getTaxesByTaxYear(taxYear);
    }
}
