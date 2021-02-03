 /*  -------------------- Program Information --------------------
    Name Of Program: Fibonacci.java
    Date of Creation: 14/12/20
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This program takes a user-given phrase and returns the Pig Latin translated version.
   

-------------------- Program Information --------------------  */


package Assignment_3_ICS_4UI;


public class Fibonacci {
    static int recursive(int number) {      // This method calls itself within itself; recursion
        if(number <= 1){
        return number;
        }
        
        return recursive(number -1) + recursive(number -2);
        
    
    } 
       
    public static void main (String args[]) 
    { 
    int test = 2; 
    System.out.println(recursive(test)); 
    } 
}