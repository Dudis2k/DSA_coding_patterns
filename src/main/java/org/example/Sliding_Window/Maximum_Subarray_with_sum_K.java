package org.example.Sliding_Window;

import java.util.Scanner;

public class Maximum_Subarray_with_sum_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        System.out.println("Enter the size of the array:");
        n = sc.nextInt();
        System.out.println("Enter the value of k:");
        k = sc.nextInt();
        int[] input_arr = new int[n];
        System.out.println("Enter elements :");
        for(int i = 0; i < n; i++) {
//            System.out.println("Enter element " + (i + 1) + ":");
            input_arr[i] = sc.nextInt();
        }
        System.out.println("Maximum subarray sum of given array with size k is "+findMaxSubarrayWithSumK(input_arr, k));
    }
    public static int findMaxSubarrayWithSumK(int[] arr, int k){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0, count = 0, start = 0;
        while(count<arr.length){
            currentSum += arr[count];
            count++;
            maxSum = Math.max(maxSum, currentSum);
            if(count>=k){
                currentSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }
}
