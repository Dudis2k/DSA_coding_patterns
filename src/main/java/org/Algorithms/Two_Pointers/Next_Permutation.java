package org.Algorithms.Two_Pointers;

import java.util.Arrays;
import java.util.Scanner;

public class Next_Permutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the input string: ");
        int len = scanner.nextInt();
        boolean flag = false;
        int[] input = new int[len];
        System.out.println("Enter the "+len+" Elements:");
        for(int i=0;i<len;i++){
            input[i] = scanner.nextInt();
        }
        next_permutation(input);
        System.out.println("Output is "+Arrays.toString(input));
    }
    
    public static void next_permutation(int[] nums){

        int breakpoint1 = -1, breakpoint2 = -1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakpoint1=i;
                break;
            }
        }

        if(breakpoint1 == -1){
            reverse(nums, 0);
        }
        else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[breakpoint1]){
                    breakpoint2 = i;
                    break;
                }
            }
            swap(nums, breakpoint1, breakpoint2);
            reverse(nums, breakpoint1+1);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
