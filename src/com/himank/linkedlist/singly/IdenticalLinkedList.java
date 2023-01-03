package com.himank.linkedlist.singly;

public class IdenticalLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList1 = getLinkedList1();
        SinglyLinkedList linkedList2 = getLinkedList2();

        System.out.println("Is LinkedList Identical? " + isIdenticalLinkedList(linkedList1, linkedList2));
    }

    private static boolean isIdenticalLinkedList(SinglyLinkedList linkedList1, SinglyLinkedList linkedList2) {
        System.out.println();
        SinglyLinkedList.Node head1 = linkedList1.getHead();
        SinglyLinkedList.Node head2 = linkedList2.getHead();

        while (head1 != null && head2 != null) {
            if(head1.data != head2.data)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;
    }

    private static SinglyLinkedList getLinkedList1() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        return linkedList;
    }

    private static SinglyLinkedList getLinkedList2() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        return linkedList;
    }
}
