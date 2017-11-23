package com.dynamicdemo;

import java.lang.reflect.*;

public class OwnerInvocationHandler implements InvocationHandler{
    private PersonBean person;

    // 将proxy传入构造器，并保持它的引用
    public OwnerInvocationHandler(PersonBean person){
        this.person = person;
    }

    // 每次proxy的方法被调用，就会导致proxy调用次方法
    public Object invoke(Object proxy,Method method,Object[] args) throws IllegalAccessException{
        try{
            // 方法如果是一个get,我们就调用person内的方法
            if(method.getName().startsWith("get")){
                return method.invoke(person,args);
            }else if(method.getName().equals("setHotOrNotRating")){
            // 如果方法是setHotOrNotRating(),我们就抛出IllegalAccessException表示不允许
                throw new IllegalAccessException();
            }else if(method.getName().startsWith("set")){
            // 因为我们是拥有者，所以任何其他set方法都可以，我们就在真正主题上调用它
                return method.invoke(person,args);
            }
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
