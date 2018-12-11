package com.rafael.server;

import com.rafael.server.database.ImplMysqlLogin;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("Server has started");
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("ribamech", new ImplMysqlLogin());
        registry.bind("kalabaracia", new ImplRegisterUsers());
    }
}
