package com.remotedemo;

import java.rmi.*;

public interface MyRemote extends Remote{
    // 客户会调用实现远程接口的Stub上的方法，而Stub底层用到了网络和I/O，所以各种坏事情都可能会
    // 发生。
    public String sayHello() throws RemoteException;
}
