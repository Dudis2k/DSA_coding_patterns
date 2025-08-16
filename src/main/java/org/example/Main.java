package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListNode head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(8);
        ListNode current = head;
        removeDuplicates(head);
        while (current  != null) {
            System.out.println("Node data: " + current.data);
            current = current.next;
        }

    }

    public static void removeDuplicates(ListNode head) {
        Set<Integer> seen = new HashSet<>();
        ListNode fast = head;
        ListNode slow = null;
        while(fast != null) {
            if(seen.add(fast.data)) {
                slow = fast;
                fast = fast.next;
            }
            else{
                slow.next = fast.next;
                fast = fast.next;
            }
        }
    }
}