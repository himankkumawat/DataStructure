package com.himank.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem225 {

    public static void main(String[] args) {
        Problem225 stack = new Problem225();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Stack is empty? " + stack.empty());
    }

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public Problem225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while(!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        queue1.add(x);
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
