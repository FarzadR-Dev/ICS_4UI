package Assignment_7_ICS_4UI;
/*  -------------------- Program Information --------------------
   Name Of Program: Customer.java
   Date of Creation: 27/01/21
   Date of Submission: 29/01/21
   Name of Author(s): Farzad Rahman
   Course: ICS 4UI
   Description: This file is a class file for the class Customer. It can be manipulated by the user using the many methods in the other file.

-------------------- Program Information --------------------  */

public class Customer {
    
    String LName;
    String FName;
    int First;
    int Second;
    int Third;
    int Fourth;
    
    public Customer(){     
        
    }


    public Customer(String LName, String FName, int First, int Second, int Third, int Fourth){      // Constructor
        this.LName = LName;
        this.FName = FName;
        this.First = First;
        this.Second = Second;
        this.Third = Third;
        this.Fourth = Fourth;
    }

    public String toString(){       // Allows the customer info to be output to a string
        return "Name: "+this.FName+" "+this.LName+"\nFirst Week: "+this.First+"\nSecond Week: "+this.Second+"\nThird Week: "+this.Third+"\nFourth Week: "+this.Fourth;
    }
    
    public int total(){         // Counts up the total points and checks if eligible for bonus
        int sum = this.First+this.Second+this.Third+this.Fourth;
        if (sum >= 5000){

            sum += 1000; 
        }
        return sum;
    }
    public int bonus(){     // Returns 1000 if eligible for bonus
        int sum = this.First+this.Second+this.Third+this.Fourth;
        int Bonus = 1000;
        if (sum >= 5000){
            return Bonus;
        }
        else{
            return 0;
        }
    }



    }

