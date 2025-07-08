package com.easyconcept.session1;

import java.util.Queue;
import java.util.LinkedList;

public class MyQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Task1");
        queue.add("Task2");
        queue.add("Task3");

        System.out.println("Head (peek): " + queue.peek()); // peek()

        System.out.println("Polling: " + queue.poll()); // poll()

        System.out.println("Head (remove): " + queue.remove()); // remove()

        queue.offer("Task4"); // offer()

        System.out.println("Contains 'Task4'? " + queue.contains("Task4")); // contains()

        System.out.println("Queue is empty? " + queue.isEmpty());

        System.out.println("Remaining tasks: " + queue);
    }
}
