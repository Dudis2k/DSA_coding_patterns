package org.example.Sliding_Window;

import java.util.*;

public class Fruits_into_Basket {
    private char[] Fruits;
    private int len;
    private Scanner scanner;
    public Fruits_into_Basket(){
        scanner = new Scanner(System.in);
    }

    public void take_inputs(){
        System.out.println("Enter the Character Array Size: ");
        len = scanner.nextInt();
        Fruits = new char[len];
        System.out.println("Characters are! - ");
        for(int i=0;i<len;i++){
            Fruits[i] = scanner.next().charAt(0);
        }
    }
    //This method is to obtain the max number of fruits count in a basket
    // if basket can fit any number of fruits but of only 2 types
    private int get_max_number_of_fruits_in_basket(){
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Integer> fruit_varieties = new HashMap<>();
        int start =0, sum =0, out =Integer.MIN_VALUE, i=0;
        while(i<Fruits.length){
            if(fruit_varieties.size()<2 || fruit_varieties.containsKey(Fruits[i])) {
                fruit_varieties.put(Fruits[i],fruit_varieties.getOrDefault(Fruits[i],0)+1);
                sum++;
            }
            else{
                while(fruit_varieties.size()>1){
                    fruit_varieties.put(Fruits[start],fruit_varieties.getOrDefault(Fruits[start],0)-1);
                    if(fruit_varieties.get(Fruits[start])==0){
                        fruit_varieties.remove(Fruits[start]);
                    }
                    sum--;
                    start++;
                }
                i--;
            }
            out = Math.max(out, sum);
            i++;
        }
        return out;
    }

    public void get_results(){
        System.out.println("Max Fruits that can be in basket are = " + get_max_number_of_fruits_in_basket());
    }
}
