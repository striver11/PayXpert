package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.model.Payroll;

public interface IPayrollService {

	void generatePayroll(int employeeId, String startDate, String endDate, double basicSalary, double overTime,
			double otherPay, double deductions);
	public void getPayrollById(int payrollId);
	List<Payroll> getPayrollsForEmployee(int employeeId);
	 List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod);
}
