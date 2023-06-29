package com.java.multithreading.forkjoinFramework.task1;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class PrintingArrayRecursiveAction extends RecursiveAction {

    private List<Integer> list;

    public PrintingArrayRecursiveAction(List<Integer> list){
        this.list=list;
    }

    @Override
    protected void compute() {
        int index1 = list.size()/2;
        if(list.size()>2){
            PrintingArrayRecursiveAction action1 = new PrintingArrayRecursiveAction(list.subList(0,index1));
            PrintingArrayRecursiveAction action2 = new PrintingArrayRecursiveAction(list.subList(index1,list.size()));
            invokeAll(action1,action2);
        }else{
            list.forEach((ele)-> System.out.print(ele+" "));
        }
    }
}
