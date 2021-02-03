 /*  -------------------- Program Information --------------------
    Name Of Program: RestaurantInventory.java
    Date of Creation: 14/12/20
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This program allows the user to control an inventory system of a restaurant.
    This includes:
Display all information currently held in the menu inventory
Displays only appetizers available
Displays only mains available
Displays only desserts available
Displays only beverages available
Add new items as they become available in the kitchen (will require all fields to be added...name, item type, number to sell and restaurant price)
Customer purchased a menu item, which will reduce number left to sell for that item
Program automatically deletes an item from the inventory if the number left to sell is 0...the kitchen has run out of the item for the day.
Change the restaurant price of any item on the menu (for specials during the day)
Exit option

-------------------- Program Information --------------------  */


package Assignment_2_ICS_4UI;

import java.util.*;

public class RestaurantInventory {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String choice;
        ArrayList <ArrayList<Object>> Inventory = new ArrayList <ArrayList<Object>>();
        ArrayList <Object> row1 = new ArrayList <Object> ();
        ArrayList <Object> row2 = new ArrayList <Object> ();
        ArrayList <Object> row3 = new ArrayList <Object> ();
        ArrayList <Object> row4 = new ArrayList <Object> ();
        ArrayList <Object> row5 = new ArrayList <Object> ();
        ArrayList <Object> row6 = new ArrayList <Object> ();
        ArrayList <Object> row7 = new ArrayList <Object> ();
        ArrayList <Object> row8 = new ArrayList <Object> ();

        /** Add the information to the rows */
        row1.add("takoyaki");
        row1.add("appetizer");
        row1.add((int) 8);
        row1.add("$7.89");
    
        row2.add("gyoza");
        row2.add("appetizer");
        row2.add((int) 1 );
        row2.add("$5.69");
       
        row3.add("bibimbap");
        row3.add("main");
        row3.add((int)4);
        row3.add("$11.00");
      
        row4.add("yakisoba");
        row4.add("main");
        row4.add((int)2);
        row4.add("$13.99");

        row5.add("daifuku");
        row5.add("dessert");
        row5.add((int)20);
        row5.add("$2.21");

        row6.add("mochi");
        row6.add("dessert");
        row6.add((int)18);
        row6.add("$2.21");

        row7.add("bubble tea");
        row7.add("drink");
        row7.add((int)35);
        row7.add("$4.80");

        row8.add("ramune");
        row8.add("drink");
        row8.add((int)40);
        row8.add("$2.45");


        Inventory.add(row1);
        Inventory.add(row2);
        Inventory.add(row3);
        Inventory.add(row4);
        Inventory.add(row5);
        Inventory.add(row6);
        Inventory.add(row7);
        Inventory.add(row8);
    
        
        System.out.println("What operation would you like to try?");
        
        System.out.println("\nTo see all info, type 'info'");
        System.out.println("\nTo see all appetizers, type 'appetizers'");
        System.out.println("\nTo see all mains, type 'mains'");
        System.out.println("\nTo see all desserts, type 'desserts'");
        System.out.println("\nTo see all drinks, type 'drinks'");
        System.out.println("\nTo add a new item, type 'add item'");
        System.out.println("\nIf a customer has purchased an item, type 'purchase'");
        System.out.println("\nTo change the price of an item, type 'edit price'");
        System.out.println("\nTo exit the program, type 'exit\n");

while(true){
    System.out.println("\nWhat will you do?");
        choice = sc.nextLine();
        choice = choice.toLowerCase();
        

        for(int i=0; i < Inventory.size(); i++){
            if (Inventory.get(i).get(2).equals((int)0)){
                System.out.println("Sold Out of "+ Inventory.get(i).get(0));
            };
        }

        if (choice.equals("info")){            // some reason a switch method made things not work. well i dont have time to know why
            Full(Inventory);
        }

        else if (choice.equals("appetizers")){
            starters(Inventory);
        }

        else if (choice.equals("mains")){
            mainCourse(Inventory);
        }

        else if (choice.equals("desserts")){
            Treat(Inventory);
        }

        else if (choice.equals("add item")){
            addition(sc, Inventory);
        }

        else if (choice.equals("edit price")){
            Edit(Inventory, sc);
        }


        else if(choice.equals("exit")){
            System.out.println("\nThank you");
            System.exit(0);
        }

    }
}



    public static void Full ( ArrayList<? extends ArrayList<?>> Collection){        // Displays entire inventory
        for(int i=0; i < Collection.size(); i++){
            if (!Collection.get(i).get(2).equals(0)){
            System.out.println( Collection.get(i).toString() );
            }
            else if (Collection.get(i).get(2).equals(0)){
                System.out.println(Collection.get(i).get(0) + " is sold out.");
            }
        }
    } 

    public static void starters(ArrayList<? extends ArrayList<?>> Collection){      // Only displays all the at-the-time appetizers
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains("appetizer")){
                System.out.println(Collection.get(i).toString());
            }
        }
    }

    public static void mainCourse(ArrayList<? extends ArrayList<?>> Collection){    // Only displays all the at-the-time main courses
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains("main")){
                System.out.println(Collection.get(i).toString());
            }
        }
    }

    public static void Treat(ArrayList<? extends ArrayList<?>> Collection){         // Only displays all the at-the-time desserts
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains("dessert")){
                System.out.println(Collection.get(i).toString());
            }
        }
    }

    public static void Beverage(ArrayList<? extends ArrayList<?>> Collection){      // Only displays all at-the-time drinks
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains("drink")){
                System.out.println(Collection.get(i).toString());
            }
        }
    }

    public static void addition(Scanner scan, ArrayList< ArrayList<Object>> Collection){    // Allows the user to add an item on the menu
        ArrayList <Object> row9 = new ArrayList <Object> ();
            System.out.println("What is it? ");
            String NewItem = scan.nextLine();
            row9.add(NewItem);
            System.out.println("What type is it? ");
            String NewType = scan.nextLine();
            row9.add(NewType);
            System.out.println("How much of it are there? ");
            int NewInventory = scan.nextInt();
            row9.add(NewInventory);
            System.out.println("How much is it? ");
            String NewPrice = scan.nextLine();
            row9.add(NewPrice);
            Collection.add(row9);

            for(int i=0; i< Collection.size(); i++){
                if (Collection.get(i).contains(NewItem)){
                    Collection.get(i).set(3,NewPrice);
                    System.out.println(Collection.get(i).toString());
                }
            

        }
    }

    public static void Pay(ArrayList<? extends ArrayList<Object>> Collection, Scanner scan){    // Allows the user to log a purchase, decreasing inventory
        System.out.println("\nWhich item was purchased?");
                String ItemPurchased = scan.nextLine();
                for(int i=0; i< Collection.size(); i++){
                    if (Collection.get(i).contains(ItemPurchased)){
                        System.out.println(Collection.get(i).toString());
                        int stock = (int) Collection.get(i).get(2);
                        Collection.get(i).set(2,stock-1);
                        System.out.println(Collection.get(i).toString());

                    }
            }
    }

    public static void Edit(ArrayList<? extends ArrayList<Object>> Collection, Scanner scan){   // Allows the user to choose a new price for an item
        for(int i=0; i < Collection.size(); i++){
            System.out.println( Collection.get(i).toString() );
        }
        System.out.println("\nWhat item would you like to edit the price of?: ");
        String Select = scan.nextLine();
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains(Select)){
                System.out.println(Collection.get(i).toString());
            }
        }
        System.out.println("\nWhat would you like the price to be?");
        String editPrice = scan.nextLine();
        for(int i=0; i< Collection.size(); i++){
            if (Collection.get(i).contains(Select)){
                Collection.get(i).set(3,editPrice);
                System.out.println(Collection.get(i).toString());
               
            }
        }
    }



}




