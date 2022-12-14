package com.stguigu.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 *
 *
 * @author shkstart
 * @create 2022-11-28 21:09
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 t1 = new MyThread1();
//        MyThread2 t2 = new MyThread2();
//        t1.start();
//        t2.start();
        //创建Thread类的匿名子类的方式
        new MyThread1(){
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }

                }
            }
        }.start();
        new MyThread2(){
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }

                }
            }
        }.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}
