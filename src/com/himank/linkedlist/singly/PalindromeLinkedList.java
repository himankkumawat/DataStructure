package com.himank.linkedlist.singly;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = getPalindromeLinkedList();

        System.out.println("LinkedList is Palindrome? " + checkPalindromeLinkedList(linkedList));
    }

    private static boolean checkPalindromeLinkedList(SinglyLinkedList linkedList1) {
        int number = 0;
        SinglyLinkedList.Node slow = linkedList1.getHead();
        SinglyLinkedList.Node fast = linkedList1.getHead();

        while (fast != null && fast.next != null) {
            number = number * 10 + slow.data;
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null)
            slow = slow.next;

        int rem;
        while (slow != null) {
            rem = number%10;
            if(rem != slow.data)
                return false;
            slow = slow.next;
            number = number/10;
        }

        return number == 0;
    }

    private static SinglyLinkedList getPalindromeLinkedList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        return linkedList;
    }
}
