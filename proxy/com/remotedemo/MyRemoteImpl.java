package com.remotedemo;

import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public String sayHello(){
        return "Server says,'Hey'";
    }

    public MyRemoteImpl() throws RemoteException{
    }

    public static void main(String[] args){
        try{
            // 要让该服务被远程客户可用，需要将此服务实例化，然后放入
            // RMI registry 中(先确定RMI Registry正在运行，否则注册会失败)
            // 当注册这个实现对象时，RMI系统其实注册的是stub，因为这是客户真正需要的。
            MyRemote service = new MyRemoteImpl();
            // 为你的服务命名，好让客户用来在注册表中寻找它。当你绑定服务对象时，RMI会把服务换成stub，然后
            // 把stub放到registry中
            Naming.rebind("RemoteHello",service);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
