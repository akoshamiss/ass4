package com.company;

import com.company.controllerss.UserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.UserRepositories;
import com.company.repositories.interfacess.IUserRepository;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepositories(db);
        UserController controller = new UserController(repo);
       MyCompany app = new MyCompany(controller);
        app.start();
    }
}
