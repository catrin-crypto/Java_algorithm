package lesson4;

import lesson3.ListObject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<ListObject> myStack = new Stack<>();
        long startStackPush = System.nanoTime();
        myStack.push(new ListObject(6, 8));
        myStack.push(new ListObject(90, 4));
        myStack.push(new ListObject(0, 22));
        long finishStackPush = System.nanoTime();
        for (ListObject obj : myStack) {
            System.out.println("My stack:" + obj.toString() + "\n Pushing time: " + (finishStackPush - startStackPush) + "ns");
        }
        System.out.println(myStack.peek());
        if (!myStack.isEmpty()) {
            myStack.pop();
        }
        for (ListObject obj : myStack) {
            System.out.println("My stack:" + obj.toString());
        }


        Queue<ListObject> myQueue = new LinkedList<>();
        long startQueueAdd = System.nanoTime();
        myQueue.add(new ListObject(5, 7));
        myQueue.add(new ListObject(66, 0));
        myQueue.add(new ListObject(1, 10));
        long finishQueueAdd = System.nanoTime();
        for (ListObject obj : myQueue) {
            System.out.println("My queue: " + obj.toString() + "\n Adding time: " + (finishQueueAdd - startQueueAdd) + " ns");
        }
        myQueue.remove();
        System.out.println(myQueue.peek());
        myQueue.offer(new ListObject(444, 222));
        myQueue.poll();
        for (ListObject obj : myQueue) {
            System.out.println("My queue: " + obj.toString());
            System.out.println("My queue size: " + myQueue.size());
        }


        Deque<ListObject> myDeque = new LinkedList<>();
        long startDequeAdd = System.nanoTime();
        myDeque.add(new ListObject(56, 32));
        myDeque.add(new ListObject(43, 3));
        myDeque.add(new ListObject(100, 1000));
        long finishDequeAdd = System.nanoTime();
        for (ListObject obj : myDeque) {
            System.out.println("My deque: " + obj.toString() + "\n Adding time: " + (finishDequeAdd - startDequeAdd) + "ns" + "\n My deque size: " + myDeque.size());
        }
        myDeque.addFirst(new ListObject(0, 555));
        myDeque.addLast(new ListObject(7777, 1));
        myDeque.remove();
        System.out.println(myDeque.getFirst());
        for (ListObject obj : myDeque) {
            System.out.println("My deque: " + obj.toString());
        }

        
        PriorityQueue<Integer> priorQueue = new PriorityQueue<>();
        long startPriorAdd = System.nanoTime();
        priorQueue.add(67);
        priorQueue.add(0);
        priorQueue.add(100);
        priorQueue.add(5);
        long finishPriorAdd = System.nanoTime();
        for (Integer integer : priorQueue) {
            System.out.println("My priority queue: " + integer.toString() + "\n Adding time: " + (finishPriorAdd - startPriorAdd) + " ns");
        }
        priorQueue.poll();
        System.out.println(priorQueue.peek());
        priorQueue.element();
        priorQueue.offer(888);
        for (Integer integer : priorQueue) {
            System.out.println("My priority queue: " + integer.toString());
        }
    }

}
