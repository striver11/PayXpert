package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.payxpert.model.Employee;
import com.hexaware.payxpert.util.DatabaseContext;

public class EmployeeDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * This is the method to insert a record in the DB.
     *
     * @param emp Employee Object.
     * @return Nothing.
     * @throws SQLException
     * @see SQLException
     */
    public void createEmployee(Employee emp) {
        try {
            con = DatabaseContext.getDBConn();
            ps = con.prepareStatement(
                    "INSERT INTO employee (employeeID, firstName, lastName, dateOfBirth, gender, email, phoneNumber, address, position, joiningDate, terminationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setInt(1, emp.getEmployeeID());
            ps.setString(2, emp.getFirstName());
            ps.setString(3, emp.getLastName());
            ps.setDate(4, new java.sql.Date(emp.getDateOfBirth().getTime()));
            ps.setString(5, emp.getGender());
            ps.setString(6, emp.getEmail());
            ps.setString(7, emp.getPhoneNumber());
            ps.setString(8, emp.getAddress());
            ps.setString(9, emp.getPosition());
            ps.setDate(10, new java.sql.Date(emp.getJoiningDate().getTime()));
            ps.setDate(11, emp.getTerminationDate() != null ? new java.sql.Date(emp.getTerminationDate().getTime()) : null);

            int noOfRows = ps.executeUpdate();
            System.out.println(noOfRows + " inserted Successfully !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    /**
     * This is the method to retrieve an employee by ID from the DB.
     *
     * @param employeeId ID of the employee to retrieve.
     * @return Employee object if found, otherwise null.
     */
    public Employee getEmployeeById(int employeeId) {
        try {
            con = DatabaseContext.getDBConn();
            ps = con.prepareStatement("SELECT * FROM employee WHERE employeeID = ?");
            ps.setInt(1, employeeId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return extractEmployeeFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return null; // Employee not found
    }
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            con = DatabaseContext.getDBConn();
            ps = con.prepareStatement("SELECT * FROM employee");
            rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = extractEmployeeFromResultSet(rs);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return employeeList;
    }

    // Utility method to extract Employee details from ResultSet
    private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
        // Extract employee details from the result set and create an Employee object
        // (Assuming you have a constructor in Employee class that takes all the details)
        return new Employee(
                rs.getInt("employeeID"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getDate("dateOfBirth"),
                rs.getString("gender"),
                rs.getString("email"),
                rs.getString("phoneNumber"),
                rs.getString("address"),
                rs.getString("position"),
                rs.getDate("joiningDate"),
                rs.getDate("terminationDate")
        );
    }
    public void updateEmployee(Employee emp) {
        try {
            con = DatabaseContext.getDBConn();
            ps = con.prepareStatement(
                    "UPDATE employee SET firstName=?, lastName=?, dateOfBirth=?, gender=?, email=?, " +
                            "phoneNumber=?, address=?, position=?, joiningDate=?, terminationDate=? " +
                            "WHERE employeeID=?");

            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setDate(3, new java.sql.Date(emp.getDateOfBirth().getTime()));
            ps.setString(4, emp.getGender());
            ps.setString(5, emp.getEmail());
            ps.setString(6, emp.getPhoneNumber());
            ps.setString(7, emp.getAddress());
            ps.setString(8, emp.getPosition());
            ps.setDate(9, new java.sql.Date(emp.getJoiningDate().getTime()));

            // Check if terminationDate is not null before accessing its time
            if (emp.getTerminationDate() != null) {
                ps.setDate(10, new java.sql.Date(emp.getTerminationDate().getTime()));
            } else {
                ps.setNull(10, java.sql.Types.DATE);
            }

            ps.setInt(11, emp.getEmployeeID());

            int noOfRows = ps.executeUpdate();
            System.out.println(noOfRows + " updated Successfully !!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    public void removeEmployee(Employee emp) {
        try {
            con = DatabaseContext.getDBConn();
            ps = con.prepareStatement("DELETE FROM employee WHERE employeeID = ?");
            ps.setInt(1, emp.getEmployeeID());

            int noOfRows = ps.executeUpdate();
            if (noOfRows > 0) {
                System.out.println(noOfRows + " employee removed Successfully !!!");
            } else {
                System.out.println("No employee removed. Employee with ID " + emp.getEmployeeID() + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    // Utility method to close resources
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
