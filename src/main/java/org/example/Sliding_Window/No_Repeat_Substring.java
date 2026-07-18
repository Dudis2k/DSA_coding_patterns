package org.example.Sliding_Window;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No_Repeat_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input String: ");
        String input = sc.nextLine();
        int max_size = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        String out = "";
        Set<Character> uq_chars = new HashSet<>();
        for(int i=0;i<input.length(); i++){
            if(!uq_chars.add(input.charAt(i))) {
                uq_chars.clear();
                sb.delete(0,sb.length());
            }
            uq_chars.add(input.charAt(i));
            max_size = Math.max(max_size, uq_chars.size());
            if(uq_chars.size()>=max_size){
                for(char c:uq_chars){
                    sb.append(c);
                }
                out = sb.toString();
                sb.delete(0,sb.length());
            }
        }
        System.out.println("Final output is "+out);
    }

}
