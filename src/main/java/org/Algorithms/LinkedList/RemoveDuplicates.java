package org.Algorithms.LinkedList;

import java.util.*;

import static org.Algorithms.LinkedList.ListNode.collectElementsOfLinkedListFromUser;
import static org.Algorithms.LinkedList.ListNode.createLinkedList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of LinkedList:");
        int len = Integer.parseInt(scanner.nextLine());

        List<Integer> items = collectElementsOfLinkedListFromUser(len);

        ListNode head = createLinkedList(items);
//        ListNode head = createLinkedList(Arrays.asList(5, 10, 2, 5, 8));
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
