package Assignment_1_ICS_4UI;

// What is N?

// by Farzad Rahman

// This program allows users to choose a number between 1 and 20,
// then choose to see the different ways to add 2 numbers to get the sum, your number.
// or see the different ways to see how 2 numbers multiply to reach your number.

import java.util.*;

public class WhatIsN{
    public static void main(String[] args){
        int n;
        int reduced;
        String Op;

        Scanner sc = new Scanner(System.in);
        System.out.println("Select a number between 1 and 20: ");
        n = sc.nextInt();
        sc.nextLine(); // EMPTY NEXT LINE TO CONSUME \n character

        if (n > 20 || n < 1){
            System.out.println("Try a number between 1 and 20");
            sc.close();
            return; 
        }
        System.out.println("Select an operation you'd like to see on your number, addition or multiplication: ");
        Op = sc.nextLine();
        Op = Op.toLowerCase();

        if (Op.equals("addition")){
            for (int i = 0; i <= (n/2); i++){
                reduced = n-i;
                System.out.println(n + " is " + i + " and " + reduced);
            }
        }

        if (Op.equals("multiplication")){
            for (int i = 1; i <= Math.sqrt(n); i++){
                if (n%i == 0){
                    reduced = n/i;
                    System.out.println(n + " is " + i + " times " + reduced);
                }
            }
        }

        if (! Op.equals("addition") && !Op.equals("multiplication")){
            System.out.println("Try addition or multiplication");
            sc.close();
            return;
        }
      sc.close();
    }
}

