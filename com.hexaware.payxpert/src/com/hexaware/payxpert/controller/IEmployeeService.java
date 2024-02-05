package com.hexaware.payxpert.controller;

import java.util.Scanner;

import com.hexaware.payxpert.model.Employee;

public interface IEmployeeService {

	void getEmployeeById(int employeeId);

	void getAllEmployees();

	void addEmployee();
	
	 Employee readEmployeeData(Scanner scanner);
	 
	  void removeEmployee(int employeeId);

	void updateEmployee(int employeeId);
}
