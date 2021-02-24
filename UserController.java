package com.company.controllerss;

import com.company.entities.employee;
import com.company.repositories.interfacess.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createEmployee(String employee_name, String employee_surname, String employee_address,int salary) {
        employee employee = new employee(employee_name, employee_surname,employee_address,salary);

        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public String getUser(int id) {
        employee employee = repo.getUser(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllUsers() {
        List<employee> employees = repo.getAllUsers();

        return employees.toString();
    }
}
