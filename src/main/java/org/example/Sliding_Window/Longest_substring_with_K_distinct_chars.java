package org.example.Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Longest_substring_with_K_distinct_chars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input_str;
        System.out.println("Enter the string:");
        input_str = sc.nextLine();
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        System.out.println("Length of longest substring with " + k + " distinct characters is " + longestSubstringWithKDistinctChars(input_str, k));
    }
    public static String longestSubstringWithKDistinctChars(String str, int k){
        int start =0, i=0;
        StringBuilder longestSubstring = new StringBuilder();
        String out = "";
        Map<Character, Integer> charCountMap = new HashMap<>();
        while(i<str.length()){
            if(charCountMap.size() < k){
                charCountMap.put(str.charAt(i), charCountMap.getOrDefault(str.charAt(i), 0) + 1);
                longestSubstring.append(str.charAt(i));
            }
            else if(charCountMap.size() == k && charCountMap.containsKey(str.charAt(i))){
                charCountMap.put(str.charAt(i), charCountMap.getOrDefault(str.charAt(i), 0) + 1);
                longestSubstring.append(str.charAt(i));
            }
            else{
                while(charCountMap.size() >= k){
                    longestSubstring.delete(0, 1);
                    charCountMap.put(str.charAt(start), charCountMap.get(str.charAt(start))-1);
                    if(charCountMap.get(str.charAt(start))==0)
                        charCountMap.remove(str.charAt(start));
                    start++;
                }
                i--;
            }
            out = (longestSubstring.length()>out.length())?longestSubstring.toString():out;
            i++;
        }
        return out;
    }
}
