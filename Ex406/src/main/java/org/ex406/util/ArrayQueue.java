package org.ex406.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<T> {
    private T[] queue;

    public ArrayQueue() {
        this.queue= (T[]) new Object[16];
        for (int i = 0; i < queue.length; i++) {
            queue[i]=null;
        }
    }

    public ArrayQueue(Integer num) {
        this.queue= (T[]) new Object[num];
        for (int i = 0; i < queue.length; i++) {
            queue[i]=null;
        }
    }

    public boolean isEmpty(){
        if(this.queue[0]==null){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(this.queue[queue.length-1]!=null){
            return true;
        }
        return false;
    }
    public void add(T item){
        for (int i = 0; i < queue.length; i++) {
            if (queue[i]==null){
                queue[i]=item;
                return;
            }
        }
    }
    public T remove(){
        final T res=queue[0];
        for (int i = 0; i < queue.length-1; i++) {
            queue[i]=queue[i+1];
        }
        queue[queue.length-1]=null;
        return res;
    }
}
