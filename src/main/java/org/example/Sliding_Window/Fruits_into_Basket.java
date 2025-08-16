package org.example.Sliding_Window;

import java.util.*;

public class Fruits_into_Basket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of the array:");
        n = sc.nextInt();
        char[] input_arr = new char[n];
        System.out.println("Enter elements :");
        for(int i = 0; i < n; i++) {
            input_arr[i] = sc.next().charAt(0);
        }
        System.out.println("Maximum number of fruits that can be collected is " + maxFruits(input_arr));
    }
    public static int maxFruits(char[] fruits) {
        Map<Character, Integer> basket = new HashMap<>();
        int i = 0, maxCount = Integer.MIN_VALUE, count = 0, start = 0;
        while(i<fruits.length) {
            basket.put(fruits[i], basket.getOrDefault(fruits[i], 0) + 1);
            count++;
            while(basket.size()>2){
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if(basket.get(fruits[start]) == 0) {
                    basket.remove(fruits[start]);
                }
                start++;
                count--;
            }
            i++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
