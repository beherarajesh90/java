package com.java.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{

    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "id : "+id;
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList();

        for(int i=0;i<5;i++){
            Future<String> futureObj = e.submit(new Processor(i+1));
            list.add(futureObj);
        }

        for(Future<String> l:list){
            try {
                System.out.println(l.get());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException executionException) {
                executionException.printStackTrace();
            }
        }
        e.shutdown();
        try {
            if(e.awaitTermination(2000,TimeUnit.MILLISECONDS)){
                e.shutdownNow();
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
