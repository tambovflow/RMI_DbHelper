package com.rafael.my_proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MysqlLogin  extends Remote {

     void login(String u, String p) throws RemoteException;
}
