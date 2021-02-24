package com.company.repositories.interfacess;

import com.company.entities.employee;

import java.util.List;

public interface IUserRepository {
    boolean createEmployee(employee employee);
    employee getUser(int id);
    List<employee> getAllUsers();
}
