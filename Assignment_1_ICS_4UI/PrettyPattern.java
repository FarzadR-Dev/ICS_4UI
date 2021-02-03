package Assignment_1_ICS_4UI;
// Pretty Pattern 

// by Farzad Rahman

// This program takes a user input number between 1 and 9, then prints a pattern defined by:

// -each line will have the same number of characters as the number chosen
// -the first line shows all periods, except the last character will be a ‘1’
// -the next line shows all periods, except the last 2 characters will be ‘2’s
// -the next line shows all periods, except the last 3 characters will be ‘3’s
// (and so on until the last line…)
// -the last line shows only the number chosen


import java.util.*;
public class PrettyPattern {
    

    public static void main(String[] args){
        int num;
        String dot = ". ";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 9: ");
        num = sc.nextInt();
        if (num > 9 || num < 1){
            System.out.println("Try a number between 1 and 9");
            sc.close();
            return; 
        }
        for (int row = 1; row <= num; row++){
            System.out.println (dot.repeat(num-row) + (Integer.toString(row)+" ").repeat(row));
        }
        sc.close();

    }
}
