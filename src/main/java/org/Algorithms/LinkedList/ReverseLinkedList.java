package org.Algorithms.LinkedList;

import java.util.List;
import java.util.Scanner;

import static org.Algorithms.LinkedList.ListNode.*;

public class ReverseLinkedList {
    private static ListNode out;
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of LinkedList:");
        int len = Integer.parseInt(scanner.nextLine());

        List<Integer> items = collectElementsOfLinkedListFromUser(len);

        ListNode head = createLinkedList(items);
        ListNode current = head;
//        printElementsOfLinkedList(current);

        current=head;
        reverse(current);
        printElementsOfLinkedList(out);
    }

    private static void reverse(ListNode current){
        if (current == null || current.next==null) {
            out = current;
            return;
        }
        reverse(current.next);
        current.next.next = current;
        current.next = null;
    }
}
