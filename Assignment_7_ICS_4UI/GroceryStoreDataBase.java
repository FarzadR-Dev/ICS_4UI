package Assignment_7_ICS_4UI;
/*  -------------------- Program Information --------------------
   Name Of Program: GroceryStoreDatabase.java
   Date of Creation: 27/01/21
   Date of Submission: 29/01/21
   Name of Author(s): Farzad Rahman
   Course: ICS 4UI
   Description: This application mimics a database and allows a grocery store to track data on customers. Out of context that sounds illegal.
   Tracks rewards points data.

-------------------- Program Information --------------------  */

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GroceryStoreDataBase {


    // 10 Customers already initialized
    public static ArrayList<Customer> Members = new ArrayList <Customer>();
    public static void main(String[] args){
        
        Customer Farzad = new Customer("Rahman", "Farzad", 777, 800, 1200, 300);
        Customer Megan = new Customer ("Gilson","Megan",690,888,930,420);
        Customer Sowad = new Customer("Khan", "Sowad",1500,2000,853,42);
        Customer Joonseo = new Customer("Lee","Joonseo",3000,1000,323,100);
        Customer Rithika = new Customer("Ben","Rithika",1000,3268,1293,400);
        Customer Yunus = new Customer("Thai", "Yunus", 1000,2000,569,900);
        Customer Sam = new Customer("Tse","Samuel",1900,1000,2850,400);
        Customer Julia = new Customer("Nicolaisen","Julia",850,7,3102,400);
        Customer Faiza = new Customer("Noor","Faiza",829,940,2345,1058);
        Customer Tianah = new Customer("Jokic","Tianah",899,920,140,4230);
    
        Members.add(Farzad);
        Members.add(Megan);
        Members.add(Sowad);
        Members.add(Joonseo);
        Members.add(Rithika);
        Members.add(Yunus);
        Members.add(Sam);
        Members.add(Julia);
        Members.add(Faiza);
        Members.add(Tianah);

    Input();
    }



    
    public static void Input(){                 // Just the loop where the user gets to choose what they wanna do.
        Scanner sc = new Scanner(System.in);
        String choice;
        while(true)       
        {
            
            System.out.println("\nWhat will you do?\n");
            System.out.println("\nOptions: \n\nType add to add a customer \nType all to see all customers \nType search to search for a customer by last name \nType searchedit to edit a customer's info \nType searchdelete to delete a customer \nType export to export database to a file \nType exit to close program");
            choice = sc.nextLine();
            choice = choice.toLowerCase();
            
            
            if (choice.equals("add")){
                Add();
            }

            else if (choice.equals("all")){         // Not a method, but it sorts it using the sort method (Selection Sort) then lists all customers
                sort(Members);
                System.out.println("\n\n");
                for (int i=0; i < Members.size(); i++){
                    System.out.println(Members.get(i).toString());
                    System.out.println("Bonus: "+Members.get(i).bonus());
                    System.out.println("Total Points: "+Members.get(i).total()+"\n");
                }
            }

            else if (choice.equals("search")){
                sort(Members);
                System.out.println("Enter last name of person: ");
                String lname = sc.nextLine();
                Search(lname, 0, Members.size()-1, Members);
            }

            else if (choice.equals("searchedit")){
                sort(Members);
                System.out.println("Enter last name of person: ");
                String lname = sc.nextLine();
                SearchEdit(lname);
            }

            else if (choice.equals("searchdelete")){
                sort(Members);
                System.out.println("Whom shall you erase off the face of this plane of existence? (By Last Name)");
                String lname = sc.nextLine();
                SearchDelete(lname);
            }

            else if (choice.equals("export")){
                export();
            }


            else if (choice.equals("exit")){
                System.out.println("\n\nHave a good day.");
                
                System.exit(0);
            }

        }
            
    }





    public static void Add(){           // User can add a new customer to database
        String LName;
        String FName;
        int First;
        int Second;
        int Third;
        int Fourth;
        Scanner SC = new Scanner(System.in);
        System.out.println("\nLast Name? ");
        LName = SC.nextLine();
        System.out.println("\nFirst Name? ");
        FName = SC.nextLine();
        System.out.println("\nFirst Week's Rewards? ");
        First = SC.nextInt();
        System.out.println("\nSecond Week's Rewards?");
        Second = SC.nextInt();
        System.out.println("\nThird Week's Rewards?");
        Third = SC.nextInt();
        System.out.println("\nFourth Week's Rewards?");
        Fourth = SC.nextInt();

        Customer temp = new Customer(LName, FName, First, Second, Third, Fourth);
        Members.add(temp);
        System.out.println("\nNew Customer Added.\n");
        // SC.close();
    }

    public static void Search(String LName, int low, int high, ArrayList <Customer> list){          // User can search for a user using their last name, BINARY SEARCH used.
        int mid;
        
        if (low > high) {
            System.out.println("Person not found.");
            return;
        }

        mid = (low + high) / 2;
        int result = LName.compareTo(list.get(mid).LName);

        if (result == 0){
                System.out.println(list.get(mid).toString());
                System.out.println("Bonus: "+list.get(mid).bonus());
                System.out.println("Total Points: "+list.get(mid).total()+"\n");
            return;
        }

        if (result < 0){
            Search(LName, low, mid-1, list);
        }

        else{
            Search(LName, mid+1, high, list);
        }
    }

                


    public static void SearchEdit(String lname){        // User can search for a customer to edit their points info
        Search(lname, 0, Members.size()-1, Members);
        Scanner SEsc = new Scanner(System.in);
        System.out.println("Which week? Enter 1, 2, 3 or 4: ");
        int week = SEsc.nextInt();
        System.out.println("What would you like edit the points to be? ");
        int points = SEsc.nextInt();
        for (int i=0;i<Members.size();i++){
            if (Members.get(i).LName.equals(lname)){
                Customer Person = Members.get(i);
                if (week == 1){
                    Person.First = points;
                }
                else if (week==2){
                    Person.Second = points;
                }
                else if (week==3){
                    Person.Third = points;
                }
                else if (week==4){
                    Person.Fourth = points;
                }
            }
        }
        System.out.println("Edit Saved. ");
    }


    public static void SearchDelete(String lname){          // User can search for a customer to delete from database 
        Search(lname, 0, Members.size()-1, Members);
        Scanner confirm = new Scanner(System.in);
        System.out.println("Are you sure you want to delete this person? ");
        String decision = confirm.nextLine();
        decision = decision.toLowerCase();
        for (int i=0;i<Members.size();i++){
            if (Members.get(i).LName.equals(lname)){
                
                if (decision.equals("yes")){
                    Members.remove(i);
                    System.out.println("Erased from existence. ");
                }
                else if(decision.equals("no")){
                    System.out.println("Action Cancelled. ");
                }

            }

        }
        

    }


    public static void sort(ArrayList <Customer> AL){       // Just a method to sort all the customers by last name alphabetically, its called before everytime they are all listed.
        // Was originally gonna make sort an option for user
        // Scanner sc = new Scanner(System.in);
        // // System.out.println("What would you like to sort by?\n'FName' for first name,\n'LName' for last name,\n'First' for first week points,\n'Second' for second week,\n'Third' for third week,\nand 'fourth' for fourth week.");
        // String type = sc.nextLine();

        for (int i=0; i < AL.size()-1; i++){
           
            int minFound = i;
            for (int r = i+1; r < AL.size(); r++){
               
                if (AL.get(r).LName.compareTo(AL.get(minFound).LName) < 0){
                    minFound = r;
                }
            }

            Customer t = AL.get(minFound);
            AL.set(minFound,AL.get(i));
            AL.set(i,t);
            
        }
    }

    public static void export(){        // User can export the current database to a text file
        try{
        PrintWriter w = new PrintWriter("database.txt");
        w.println("Database\n\n");
        sort(Members);
        for (int i=0; i < Members.size(); i++){
            w.println(Members.get(i).toString());
            w.println("Bonus: "+Members.get(i).bonus());
            w.println("Total Points: "+Members.get(i).total()+"\n");
            }
            w.close();
            System.out.println("Database Exported");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        
        
    }





}


