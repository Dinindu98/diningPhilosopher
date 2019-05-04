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
public class DiningPhilosopher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Philosopher[] philosopher = new Philosopher[5];
        Object[] chopStick = new Object[5];
        
        for(int k=0;k<5;k++){
            chopStick[k]= new Object();
        }
        
        for(int j=0;j<5;j++){
            Object leftChopstick = chopStick[j];
            Object rightChopstick = chopStick[(j+1)%5];
            
            
            if(j==4){
                philosopher[j] = new Philosopher(rightChopstick,leftChopstick);
            }else{
                philosopher[j] = new Philosopher(leftChopstick,rightChopstick);
            }
            Thread t = new Thread( philosopher[j],"Philosopher " + (j+1));
            t.start();
        }
        // TODO code application logic here
    }
    
}
