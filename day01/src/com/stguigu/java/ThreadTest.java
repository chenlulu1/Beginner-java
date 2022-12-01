package com.stguigu.java;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1、创建一个继承于Thread类的子类
 * 2、重写Thread类的run()
 * 3、创建Thread的子类对象
 * 4、通过此对象调用调用start()
 *
 * 例子：遍历100以内的偶数
 *
 * @author shkstart
 * @create 2022-11-28 20:41
 */
//1、创建一个继承于Thread类的子类
class MyThread extends Thread{
//   2、重写Thread类的run()

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        3、创建Thread的子类对象
        MyThread t = new MyThread();
//        4、通过此对象调用调用start()：①启动当前线程②调用当前线程的run()

        t.start();
        //问题一：我们不能通过直接调用run()的方式启动线程
        //t.run();
        //问题二：在启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。会报IllegalThreadStateException
//        t.start();
        //我们需要重新穿件一个线程的对象
        MyThread t1 = new MyThread();
        t1.start();
//        System.out.println("Hello");
//        如下操作仍然是在main线程中执行的
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"*******mian********");
            }

        }

    }

}
