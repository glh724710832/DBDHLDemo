package com.gary.dbdhldemo.activity;



//单例模式—双重检查
public class Singleton {

    //1.私有权限修饰符构造器
    private  Singleton(){}                          //构造器必须私有权限修饰符，避免被外部类引用创造实例

    //2.私有权限修饰符+静态申明变量
    private static volatile Singleton singleton;     //静态方法只能引用静态变量

    //3.在方法中经过双重检查确认没有实例后创建实例并返回Singleton类型的实例singleton
    //（第一重检查可以避免线程同步等待请求锁资源，第二种检查起到线程安全，可以避免创建两个或多个实例）
    public static Singleton getInstance(){       //调用getInstance()方法创建返回实例
        if(singleton ==null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }

            }

        }
            return singleton;

    }

}

//静态内部类单例模式
/*

 */
//public class Singleton{
//
//    private  Singleton(){
//    }
//
//    private static class SingletonInstance {
//        private static Singleton singleton = new Singleton();
//    }
//
//    private  static Singleton getInstance(){
////
////            return SingletonInstance.singleton;
////
//    }
//}
