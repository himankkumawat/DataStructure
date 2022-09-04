package com.himank.linkedlist.singly;

public class SinglyLinkedList {

    private Node head;

    public class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return newNode;
    }

    public Node addAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0 && head != null) {
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        int i = 1;
        Node temp = head;
        while (index != i && temp.next != null) {
            temp = temp.next;
            i++;
        }
        if (i == index) {
            newNode.next = temp.next;
            temp.next = newNode;
            return newNode;
        }
        System.out.println("Invalid Index...");
        return null;

    }

    public void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.addAtIndex(0, 1);

        linkedList.displayLinkedList();
    }
}
