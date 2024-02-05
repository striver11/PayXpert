	package com.hexaware.payxpert.main;
	
	import com.hexaware.payxpert.exception.EmployeeNotFoundException;
	import com.hexaware.payxpert.exception.InvalidInputException;
	import com.hexaware.payxpert.exception.DatabaseConnectionException;
	import com.hexaware.payxpert.model.Employee;
	import com.hexaware.payxpert.controller.EmployeeService;
	import com.hexaware.payxpert.controller.IEmployeeService;
	import com.hexaware.payxpert.controller.FinancialRecordService;
	import com.hexaware.payxpert.controller.IFinancialRecordService;
	import com.hexaware.payxpert.controller.IPayrollService;
	import com.hexaware.payxpert.controller.PayrollService;
	import com.hexaware.payxpert.controller.ITaxService;
	import com.hexaware.payxpert.controller.TaxService;
	import com.hexaware.payxpert.dao.EmployeeDao;
	import com.hexaware.payxpert.dao.PayrollDao;
	import com.hexaware.payxpert.dao.TaxDao;
	
	import java.util.Scanner;
	
	public class PayXpertApp {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        TaxDao taxDao = new TaxDao(); // Instantiate TaxDao (or your specific implementation)
	        ITaxService taxService = new TaxService(taxDao); // Pass TaxDao instance to TaxService constructor
	
	        EmployeeDao employeeDao = new EmployeeDao(); // Initialize appropriately
	        PayrollDao payrollDao = new PayrollDao(); // Initialize appropriately
	
	
	        // Instantiate services
	        IEmployeeService employeeService = new EmployeeService();
	        IPayrollService payrollService = new PayrollService(employeeDao, payrollDao);
	
		      
		        IFinancialRecordService financialRecordService = new FinancialRecordService();
	
	        do {
	            System.out.println("Choose a service:");
	            System.out.println("1. EmployeeService");
	            System.out.println("2. PayrollService");
	            System.out.println("3. ITaxService");
	            System.out.println("4. IFinancialRecordService");
	            System.out.println("0. Exit");
	
	            int serviceChoice = scanner.nextInt();
	
	            switch (serviceChoice) {
	                case 1:
	                    performEmployeeService(employeeService, scanner);
	                    break;
	                case 2:
	                    performPayrollService(payrollService, scanner);
	                    break;
	                case 3:
	                    performTaxService(taxService, scanner);
	                    break;
	                case 4:
	                    performFinancialRecordService(financialRecordService, scanner);
	                    break;
	                case 0:
	                    System.out.println("Exiting PayXpertApp. Thank you!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	
	            System.out.println("Do you want to continue? (Y/N): ");
	            String choice = scanner.next();
	
	            if (!choice.equalsIgnoreCase("Y")) {
	                System.out.println("Exiting PayXpertApp. Thank you!");
	                break;
	            }
	        } while (true);
	
	        scanner.close();
	    }
	
	    private static void performEmployeeService(IEmployeeService employeeService, Scanner scanner) {
	        System.out.println("Choose operation for EmployeeService:");
	        System.out.println("1. getEmployeeById");
	        System.out.println("2. getAllEmployees");
	        System.out.println("3. addEmployee");
	        System.out.println("4. updateEmployee");
	        System.out.println("5. removeEmployee");
	
	        int operationChoice = scanner.nextInt();
	        switch (operationChoice) {
	        case 1:
	            System.out.println("Enter employeeId:");
	            int employeeId = scanner.nextInt();
	            employeeService.getEmployeeById(employeeId);
	            break;
	        case 2:
	            employeeService.getAllEmployees();
	            break;
	        case 3:
	            employeeService.addEmployee();
	            break;
	        case 4:
	        	System.out.println("Enter employeeId:");
	            int employeeIdU = scanner.nextInt();
	            employeeService.updateEmployee(employeeIdU);
	            break;
	        case 5:
	            System.out.println("Enter employeeId to remove:");
	            int employeeIdToRemove = scanner.nextInt();
	            employeeService.removeEmployee(employeeIdToRemove);
	            break;
	        default:
	            System.out.println("Invalid choice. Please enter a valid option.");
	    }
	    }
	
	//	private static Employee readEmployeeData(Scanner scanner) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	
	    private static void performPayrollService(IPayrollService payrollService, Scanner scanner) {
	    	 System.out.println("Choose operation for PayrollService:");
	    	    System.out.println("1. generatePayroll");
	    	    System.out.println("2. getPayrollById");
	    	    System.out.println("3. getPayrollsForEmployee");
	    	    System.out.println("4. getPayrollsForPeriod");
	
	    	    int operationChoice = scanner.nextInt();
	
	    	    switch (operationChoice) {
	    	    case 1:
	    	        System.out.println("Enter employeeId, startDate, and endDate:");
	    	        int employeeId = scanner.nextInt();
	    	        String startDate = scanner.next();
	    	        String endDate = scanner.next();
	    	        System.out.println("Enter basic salary:");
	    	        double basicSalary = scanner.nextDouble();
	    	        System.out.println("Enter overtime pay:");
	    	        double overtimePay = scanner.nextDouble();
	    	        System.out.println("Enter other pay:");
	    	        double otherPay = scanner.nextDouble();
	    	        System.out.println("Enter deductions:");
	    	        double deductions = scanner.nextDouble();
	    	        payrollService.generatePayroll(employeeId, startDate, endDate, basicSalary, overtimePay, otherPay, deductions);
	    	        break;
	    	        case 2:
	    	            System.out.println("Enter payrollId:");
	    	            int payrollId = scanner.nextInt();
	    	            payrollService.getPayrollById(payrollId);
	    	            break;
	    	        case 3:
	    	            System.out.println("Enter employeeId:");
	    	            int empIdForPayrolls = scanner.nextInt();
	    	            payrollService.getPayrollsForEmployee(empIdForPayrolls);
	    	            break;
	    	        case 4:
	    	            System.out.println("Enter startDate and endDate for the period:");
	    	            String startPeriod = scanner.next();
	    	            String endPeriod = scanner.next();
	    	            payrollService.getPayrollsForPeriod(startPeriod, endPeriod);
	    	            break;
	    	        default:
	    	            System.out.println("Invalid choice. Please enter a valid option.");
	    	    }
	    }
	
	    private static void performTaxService(ITaxService taxService, Scanner scanner) {
	        System.out.println("Choose operation for TaxService:");
	        System.out.println("1. CalculateTax");
	        System.out.println("2. GetTaxById");
	        System.out.println("3. GetTaxesForEmployee");
	        System.out.println("4. GetTaxesForYear");
	
	        int operationChoice = scanner.nextInt();
	
	        switch (operationChoice) {
	//            case 1:
	//                System.out.println("Enter employeeId and taxYear:");
	//                int empIdForTaxCalculation = scanner.nextInt();
	//                int taxYearForCalculation = scanner.nextInt();
	//                taxService.calculateTax(empIdForTaxCalculation, taxYearForCalculation);
	//                break;
	            case 2:
	                System.out.println("Enter taxId:");
	                int taxId = scanner.nextInt();
	                taxService.printTaxesById( taxId);
	                break;
	            case 3:
	                System.out.println("Enter employeeId:");
	                int empIdForTaxes = scanner.nextInt();
	                taxService.printTaxesByEmployeeId(empIdForTaxes);
	                break;
	            case 4:
	                System.out.println("Enter taxYear:");
	                int taxYear = scanner.nextInt();
	                taxService.printTaxesByTaxYear(taxYear);
	                break;
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	        }
	
	    }
	
	    private static void performFinancialRecordService(IFinancialRecordService financialRecordService, Scanner scanner) {
	    	 System.out.println("Choose operation for FinancialRecordService:");
	    	    System.out.println("1. AddFinancialRecord");
	    	    System.out.println("2. GetFinancialRecordById");
	    	    System.out.println("3. GetFinancialRecordsForEmployee");
	    	    System.out.println("4. GetFinancialRecordsForDate");
	
	    	    int operationChoice = scanner.nextInt();
	
	    	    switch (operationChoice) {
//	    	        case 1:
//	    	            System.out.println("Enter employeeId, description, amount, and recordType:");
//	    	            int empIdForFinancialRecord = scanner.nextInt();
//	    	            String description = scanner.next();
//	    	            double amount = scanner.nextDouble();
//	    	            String recordType = scanner.next();
//	    	            financialRecordService.addFinancialRecord(empIdForFinancialRecord, description, amount, recordType);
//	    	            break;
	    	        case 2:
	    	            System.out.println("Enter recordId:");
	    	            int recordId = scanner.nextInt();
	    	            financialRecordService.printFinancialRecordsById(recordId);
	    	            break;
	    	        case 3:
	    	            System.out.println("Enter employeeId:");
	    	            int empIdForFinancialRecords = scanner.nextInt();
	    	            financialRecordService.printFinancialRecordsByEmployeeId(empIdForFinancialRecords);
	    	            break;
	//    	        case 4:
	//    	            System.out.println("Enter recordDate (in yyyy-MM-dd format):");
	//    	            String recordDate = scanner.next();
	//    	            financialRecordService.getFinancialRecordsForDate(recordDate);
//	    	            break;
	    	        default:
	    	            System.out.println("Invalid choice. Please enter a valid option.");
	    	    }
	    }
	}
