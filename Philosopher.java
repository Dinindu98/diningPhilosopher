/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosopher;

/**
 *
 * @author HP
 */
public class Philosopher implements Runnable{
    private Object leftChopstick;
    private Object rightChopstick;
    
    public Philosopher(Object leftChopstick, Object rightChopstick){
        this.leftChopstick=leftChopstick;
        this.rightChopstick= rightChopstick;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                action(System.nanoTime()+" : Thinking");
                synchronized(leftChopstick){
                    action(System.nanoTime()+" : picked up left chopstick");
                    synchronized(rightChopstick){
                        action(System.nanoTime()+" : picked up right chopstick- eating");
                        action(System.nanoTime()+" : put down right chopstick");
                    }
                    action(System.nanoTime()+" : put down left chopstick- thinking");
                }
            }
        }catch(InterruptedException e){
             Thread.currentThread().interrupt();
             return;
        }
    }
    
    private void action(String task) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" "+task);
        Thread.sleep(((int)(Math.random()*100)));
    }
}
