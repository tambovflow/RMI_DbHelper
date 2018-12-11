package com.rafael.client;

import com.rafael.my_proxy.MysqlLogin;
import com.rafael.my_proxy.UserRegistrator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);
    private static UserRegistrator userRegistrator;
    private static MysqlLogin mysqlLogin;
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        mysqlLogin = (MysqlLogin) Naming.lookup("rmi://localhost:1099/ribamech");
        mysql();

        userRegistrator = (UserRegistrator) Naming.lookup("rmi://localhost:1099/kalabaracia");

        while (true){
            System.out.println("Enter command");
            System.out.println("(C) -> Create new user");
            System.out.println("(U) -> Users list");
            String command = scanner.nextLine();
            switch (command.toUpperCase()){
                case "C": createUser();
                    break;
                case "U": usersList();
                    break;
            }
        }
    }

    public static void mysql() throws RemoteException {
        System.out.print("Mysql user 'default root': ");
        String u = scanner.nextLine();
        System.out.print("Mysql pass: ");
        String p = scanner.nextLine();
        mysqlLogin.login(u, p);
    }

    public static void createUser() throws RemoteException {
        System.out.print("First name: ");
        String fName = scanner.nextLine();
        System.out.print("Last name: ");
        String lName = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        userRegistrator.addUser(fName, lName, age);
        System.out.println("ok");
    }

    public static void usersList() throws RemoteException {
        List<String> usersList = userRegistrator.getUserList();
        if(usersList != null) {
            for (String user : usersList) {
                System.out.println(user);
            }
            System.out.println();
        }
    }
}
