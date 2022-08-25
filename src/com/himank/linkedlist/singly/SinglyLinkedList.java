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

    public Node addNode(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return newNode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return newNode;
    }

    public void displayLinkedList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);

        linkedList.displayLinkedList();
    }
}
