package com.company.entities;

public class employee {
    private int employee_id;
    private String employee_name;
    private String employee_surname;
    private String employee_address;
    private int salary;

    public employee() {

    }

    public employee(String employee_name, String employee_surname, String employee_address,int salary) {
        setEmployee_name(employee_name);
        setEmployee_surname(employee_surname);
        setEmployee_address(employee_address);
        setSalary(salary);
    }

    public employee(int employee_id, String employee_name, String employee_surname, String employee_address,int salary) {
        setEmployee_id(employee_id);
        setEmployee_name(employee_name);
        setEmployee_surname(employee_surname);
        setEmployee_address(employee_address);
        setSalary(salary);
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_surname() {
        return employee_surname;
    }

    public void setEmployee_surname(String employee_surname) {
        this.employee_surname = employee_surname;
    }



    @Override
    public String toString() {
        return "Employee " +
                "id= " + employee_id +
                ", name= " + employee_name + '\'' +
                ", surname= " + employee_surname + '\'' +
                " addres = " + employee_address + " salary " + salary;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
