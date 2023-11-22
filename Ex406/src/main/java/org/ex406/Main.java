package org.ex406;

import org.ex406.util.ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>(10);

        System.out.println("测试入队：");
        for (int i = 0; i < 20; i++) {
            if (!queue.isFull()){
                queue.add(i);
                System.out.printf("[%d] added. \n",i);
            }else {
                System.out.printf("队列已满，[%d] not added.\n",i);
            }
        }

        System.out.println("测试出队：");
        while (!queue.isEmpty()){
            System.out.printf("[%d] removed.\n",queue.remove());
        }

    }
}
