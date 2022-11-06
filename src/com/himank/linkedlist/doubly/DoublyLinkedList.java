package com.himank.linkedlist.doubly;

public class DoublyLinkedList {

    private Node head;

    public class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return newNode;
        }
        Node temp = head;
        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = newNode;
        newNode.left = temp;

        return newNode;
    }

    public Node addAtIndex(int data, int index) {
        if (index == 0 && head != null) {
            Node newNode = new Node(data);
            newNode.right = head;
            head = newNode;
            return newNode;
        }
        int i = 1;
        Node temp = head;
        while (index != i && temp.right != null) {
            temp = temp.right;
            i++;
        }
        if (i == index) {
            Node newNode = new Node(data);
            newNode.right = temp.right;
            newNode.left = temp;
            temp.right = newNode;
            if (newNode.right != null)          // when we are inserting at the end of linkedlist.
                newNode.right.left = newNode;
            return newNode;
        }
        System.out.println("Invalid index...");
        return null;
    }

    public void display() {
        Node temp = head;
        System.out.println("Printing all elements of linkedlist...");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.addAtIndex(0, 2);

        doublyLinkedList.display();
    }

}
