 /*  -------------------- Program Information --------------------
    Name Of Program: PigLatin.java
    Date of Creation: 14/12/20
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This program takes a user-given phrase and returns the Pig Latin translated version.
   

-------------------- Program Information --------------------  */



package Assignment_2_ICS_4UI;

import java.util.*;


public class PigLatin{

    public static void main(String[] args){
        String phrase;
        String[] words;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a phrase to be translated to Pig Latin: ");
        phrase = sc.nextLine();
        sc.close();
        words = phrase.split(" ");

        execute(words);
    
    }




    public static void execute(String[] items){     // Executes the process of the program, creating the functioning translation
        for (int i = 0; i < items.length; i++ ){
            String word = items[i];
            String first = word.substring(0,1);
            items[i] = word.substring(1) + first + "ay";
    
        }
        System.out.println("Translated: " + String.join(" ", items).toUpperCase());
    }
}
