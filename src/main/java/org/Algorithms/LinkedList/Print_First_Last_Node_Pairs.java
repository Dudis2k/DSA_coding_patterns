package org.Algorithms.LinkedList;

import java.util.List;
import java.util.Scanner;

import static org.Algorithms.LinkedList.ListNode.*;


public class Print_First_Last_Node_Pairs {
    private static ListNode first;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of LinkedList:");
        int len = Integer.parseInt(scanner.nextLine());

        List<Integer> items = collectElementsOfLinkedListFromUser(len);

        ListNode node = createLinkedList(items);
        ListNode head = node;

        printElementsOfLinkedList(node);
        //reassign first node to 'node' and 'first' variable.
        node = head;
        first = head;

        System.out.println("Output would be: ");
        printInPairs(node, len/2);
    }

    private static int printInPairs(ListNode tail, int count){
        if (tail == null) {
            return count;
        }
        if(first != null){
            count = printInPairs(tail.next, count);
            if (count>0)
                System.out.println(first.data + " " + tail.data);
            first = first.next;
        }
        count--;
        return count;
    }
}