package com.rafael.my_proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserRegistrator extends Remote {
    boolean addUser(String firstName, String lastName, int age) throws RemoteException;
    List<String> getUserList() throws RemoteException;
}
