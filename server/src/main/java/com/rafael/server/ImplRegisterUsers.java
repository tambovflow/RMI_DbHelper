package com.rafael.server;

import com.rafael.my_proxy.UserRegistrator;
import com.rafael.server.database.DbHelper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ImplRegisterUsers extends UnicastRemoteObject implements UserRegistrator {
    protected ImplRegisterUsers() throws RemoteException {
    }


    public boolean addUser(String firstName, String lastName, int age) throws RemoteException {
        return DbHelper.addUsers(firstName, lastName, age);
    }

    public List<String> getUserList() throws RemoteException {
        return DbHelper.getUsersList();
    }
}
