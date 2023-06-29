package com.java.multithreading.diningPhilosophersProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    /*
    *  main aim is to avoid thread starvation
    *  avoid deadlock using tryLock()
    * */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Philosopher[] philosophers = null;
        Chopstick[] chopsticks = null;
        try{
            philosophers = new Philosopher[Constants.NO_OF_PHILOSOPHERS];
            chopsticks = new Chopstick[Constants.NO_OF_CHOPSTICKS];
            service = Executors.newFixedThreadPool(Constants.NO_OF_PHILOSOPHERS);

            for(int i=0;i<Constants.NO_OF_CHOPSTICKS;i++){
                chopsticks[i]=new Chopstick(i);
            }

            for(int i=0;i<Constants.NO_OF_CHOPSTICKS;i++){
                philosophers[i] = new Philosopher(i,chopsticks[i],chopsticks[(i+1)%Constants.NO_OF_CHOPSTICKS]);
                service.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

            for(Philosopher philosopher:philosophers){
                philosopher.setFull(true);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();

            while (!service.isTerminated()){
                Thread.sleep(1000);
                for(Philosopher philosopher:philosophers){
                    System.out.println(philosopher+" eat "+philosopher.getEatingCount()+" times.");
                }
            }
        }
    }
}
