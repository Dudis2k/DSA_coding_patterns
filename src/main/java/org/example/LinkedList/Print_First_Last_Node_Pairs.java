package org.example.LinkedList;

import org.example.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Print_First_Last_Node_Pairs {
    private static ListNode first;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> items = new ArrayList<>();
        System.out.println("Enter the size of LinkedList:");
        int len = Integer.parseInt(scanner.nextLine());
        ListNode head = new ListNode(0);
        ListNode node = head;
        System.out.println("Enter the elements of LinkedList:");
        IntStream.range(0, len).forEach(i -> {
                String input = scanner.nextLine();
                items.add(Integer.parseInt(input));
            }
        );
        createLinkedList(items, node);
        node = head;
        System.out.println("Elements of LinkedList:");
        printElementsOfLinkedList(node);
        first = head.next;
        node = first;
        System.out.println("Output would be: ");
        printInPairs(node, len/2);
    }
    private static void createLinkedList(List<Integer> nums, ListNode node){
        for (Integer num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
    }
    private static void printElementsOfLinkedList(ListNode node){
        while (node!=null){
            System.out.print(node.data + " ");
            node=node.next;
        }
        System.out.println();
    }
    private static int printInPairs(ListNode tail, int count){
        if (tail == null) {
            return count;
        }
        if(first != null && count > 0){
            count = printInPairs(tail.next, count);
            if (count>=0)
                System.out.println(first.data + " " + tail.data);
            first = first.next;
        }
        count--;
        return count;
    }
}