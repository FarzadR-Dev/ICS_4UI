package Assignment_5_ICS_4UI;


 /*  -------------------- Program Information --------------------
    Name Of Program: SortingEfficiences.java
    Date of Creation: 27/01/21
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This program creates an array of n random numbers where n is a number chosen by the user. 
    The program will use different sorting algorithims to sort it and output the number of loops, comparisons, moves,
    and time it took for each algorithm. 


-------------------- Program Information --------------------  */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class LibraryBookSearch {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc = new Scanner(System.in);
        File Library = new File("Assignment_5_ICS_4UI\\booklist.txt");                    
        int ID_choice;
        System.out.println("Enter ID number of book: ");
        ID_choice = sc.nextInt();
        sc.close();

        
        ArrayList <Integer> IDs = new ArrayList <Integer> ();
        ArrayList <String> Titles = new ArrayList <String> ();

        Scanner SC = new Scanner(Library);
        while (SC.hasNext()){
            int num = SC.nextInt(); 
            SC.nextLine();                      // To get the new line after line break
            String title = SC.nextLine();
            IDs.add(num);
            Titles.add(title);
            // System.out.println(num + " " + title);                
        }

        int[] ids = new int[IDs.size()];

        String[] titles = new String[Titles.size()];
        for (int i=0; i < IDs.size(); i++){
            ids[i] = IDs.get(i);
            titles[i] = Titles.get(i);
        }
        
        Linear(titles, ids, ID_choice);
        Binary(ID_choice, 0, ids.length-1, titles, ids);

        SC.close();
    
        
    }


  


    public static void Linear(String[] Names, int[] IDs, int ID_use){       // This searching algorithm simply goes through each element one by one until it finds the desired element.
        for (int i=0; i <IDs.length; i++) {
            if(IDs[i] == ID_use){
                System.out.println("Linear Search: Found it. " + Names[i]);
                return;
            }
        }
        System.out.println("ID not recognized. ");
        
    }




    public static void Binary(int ID_choice, int low, int high, String[] Names, int[] IDs){  // This algorithm repeatedly divides the array in half until it lands on the desired number.
        int mid;
        
        if (low > high) {
            System.out.println("ID not recognized. ");
            return;
        }

        mid = (low + high) / 2;
        
        if (IDs[mid] == ID_choice ){
            System.out.println("Binary Search: Found it. " + Names[mid]);
            return;
        }

        if (IDs[mid] > ID_choice){
            Binary(ID_choice, low, mid-1, Names, IDs);
        }

        else{
            Binary(ID_choice, mid+1, high, Names, IDs);
        }

        
    }








}
