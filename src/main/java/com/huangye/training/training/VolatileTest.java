package com.huangye.training.training;

/**
 * Created by huangye on 2017/3/31.
 */
public class VolatileTest {
    private static volatile int age;
    public static void increase(){
        age++;
    }
    public static void main(String agrs[]){
        Thread[] theads = new Thread[2];
        for(int i=0;i<2;i++){
           theads[i] = new Thread(new Runnable() {
               public void run() {
                   for(int j = 0;j<10;j++){
                       increase();
                   }
               }
           });
            theads[i].start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(age);
    }
}
