package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.employee;
import com.company.repositories.interfacess.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepositories implements IUserRepository {
    private final IDB db;

    public UserRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Employee(employee_name,employee_surname,employee_address,salary) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getEmployee_name());
            st.setString(2, employee.getEmployee_surname());
            st.setString(3, employee.getEmployee_address());
            st.setInt(4, employee.getSalary());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public employee getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM data1 WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                employee employee = new employee(

                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("surname"),
                        rs.getInt("Salary"));


                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<employee> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM Positions";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<employee> employees = new LinkedList<>();
            while (rs.next()) {
                employee employee = new employee(  rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("surname"),
                        rs.getInt("Salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}

