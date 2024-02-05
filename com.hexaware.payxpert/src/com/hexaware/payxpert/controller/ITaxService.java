package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.model.Tax;

public interface ITaxService {
	  public void printTaxesById(int taxId);
	  public void printTaxesByEmployeeId(int customerId);
	  public void printTaxesByTaxYear(int taxYear);
}
