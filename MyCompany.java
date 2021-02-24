package com.company;

import com.company.controllerss.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyCompany {
    private final UserController controller;
    private final Scanner scanner;

    public MyCompany (UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Company ");
            System.out.println("Select option:");
            System.out.println("1. Get all Positions");
            System.out.println("2. Get Employee by id");
            System.out.println("3. Create Employee");
            System.out.println("4. Modify Employee");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllUsersMenu();
                } else if (option == 2) {
                    getUserByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name");
        String employee_name = scanner.next();
        System.out.println("Please enter surname");
        String employee_surname = scanner.next();
        System.out.println("Please enter employee_address");
        String employee_address = scanner.next();
        System.out.println("Please enter salary");
        Integer salary = scanner.nextInt();

        String response = controller.createEmployee(employee_name, employee_surname,employee_address,salary);
        System.out.println(response);
    }
}
