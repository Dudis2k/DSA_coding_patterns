package org.Algorithms.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@Builder
public class ListNode {
    static Scanner scanner = new Scanner(System.in);
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public static ListNode createLinkedList(List<Integer> nums){
        System.out.println("Creating LinkedList.");
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (Integer num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }

    public static void printElementsOfLinkedList(ListNode node){
        System.out.println("Elements of LinkedList:");
        while (node!=null){
            System.out.print(node.data + " ");
            node=node.next;
        }
        System.out.println();
    }

    public static List<Integer> collectElementsOfLinkedListFromUser(int len){
        List<Integer> items = new ArrayList<>();
        System.out.println("Enter the elements of LinkedList:");
        IntStream.range(0, len).forEach(i -> {
                    String input = scanner.nextLine();
                    items.add(Integer.parseInt(input));
                }
        );
        return items;
    }
}
