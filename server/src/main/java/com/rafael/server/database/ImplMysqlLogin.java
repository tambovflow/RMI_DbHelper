package com.rafael.server.database;

import com.rafael.my_proxy.MysqlLogin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplMysqlLogin extends UnicastRemoteObject implements MysqlLogin {
    private static String U;
    private static String P;
    public ImplMysqlLogin() throws RemoteException {
    }

    @Override
    public void login(String u, String p) throws RemoteException {

        if(u.equals("")) u = "root";
        U=u;
        P=p;
    }

    public static String getU(){
        return U;
    }
    public static String getP(){
        return P;
    }
}
