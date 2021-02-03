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
import java.util.Date;

public class SortingEfficiencies {
    public static void main(String[] args){
        int min = -1000;
        int max = 1000;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers, 8, 25 or 100? ");
        int Choice = sc.nextInt();
        int[] arr = new int[Choice];
        sc.close();
        System.out.println(" \nUnsorted Array: \n");
        for (int i=0; i < arr.length; i++){
            int random_num = (int)(Math.random() * (max - min + 1) + min);
            arr[i] = random_num;
            System.out.println(arr[i]);
        }   
        
        t1 = new Date();
        Bubble(arr);
        Selection(arr);
        Insertion(arr);
        quick(arr,0,arr.length-1);
        PrintQuick(arr);

    
    }
    
public static Date t1;   // A start time before all the algorithms. 




    public static void Selection(int[] arr){     // This algorithm goes through the array and whenever it finds a new lowest value found, it places it at the beginning.
        int loops = 0;
        int comparisons = 0;
        int moves = 0;
        


        for (int i=0; i < arr.length-1; i++){
            loops++;
            comparisons++;
            int minFound = i;
            for (int r = i+1; r < arr.length; r++){
                comparisons++;
                loops++;
                if (arr[r] < arr[minFound]){
                    minFound = r;
                    // moves++;
                }
            }

            int t = arr[minFound];
            arr[minFound] = arr[i];
            arr[i] = t;
            moves++;
        }
        
        System.out.println("\nSelection Sort\n");
        for (int i=0; i<arr.length;++i){

            System.out.println(arr[i] + " ");
        }
        Date t2 = new Date();
        System.out.println("\nLoops: " + loops+ "\nComparisons: "+comparisons+ "\nMoves: " + moves+ "\nTime: "+(t2.getTime()-t1.getTime())+"ms");
    }







    public static void Insertion(int[] arr){   // This algorithm goes through, and compares the current index to the element before it, if less than the predecessor, it compares to the element before that and so on. 
        int loops = 0;
        int comparisons = 0;
        int moves = 0;

        for (int i=1; i < arr.length; ++i){
            int pre = i-1;
            int m = arr[i];
            loops++;
            comparisons++;
            while (pre >= 0 && arr[pre] > m){
                arr[pre+1] = arr[pre];
                pre = pre-1;
                comparisons++;
                loops++;
                moves++;
            }
            arr[pre+1] = m;
            moves++;

        }
        System.out.println("\nInsertion Sort");
        // for (int i=0; i<arr.length;++i){

        //     System.out.println(arr[i] + " ");
        // }
        Date t2 = new Date();
        System.out.println("Loops: " + loops+ "\nComparisons: "+comparisons+ "\nMoves: " + moves+ "\nTime: "+(t2.getTime()-t1.getTime())+"ms");
        
    }




    public static void Bubble(int[] arr){   // This algorithm takes the first two elements, and swaps them if in wrong order, then continues with the next and so on. 
        int loops=0;
        int comparisons=0;
        int moves=0;

        for (int i=0; i < arr.length; i++){
            loops++;
            moves++;
            for (int l = 0; l < arr.length - i - 1; l++){
                loops++;
                comparisons++;
                if (arr[l] > arr[l+1]){
                    moves++;
                    int virtual = arr[l];
                    arr[l] = arr[l+1];
                    arr[l+1] = virtual;
                }
                
            }
            
            
        }
        System.out.println("\nBubble Sort");
        // for (int i=0; i<arr.length;++i){

        //     System.out.println(arr[i] + " ");
        // }
        Date t2 = new Date();
        System.out.println("Loops: " + loops+ "\nComparisons: "+comparisons+ "\nMoves: " + moves+ "\nTime: "+(t2.getTime()-t1.getTime())+"ms");
        
    }



// This is where the entirety of the quicksort is 0_o


    public static void random(int arr[], int low, int high){    // Generates a random pivot spot in the array.

        Random r = new Random();
        int pivot = r.nextInt(high-low)+low;
        int temp1=arr[pivot];
        arr[pivot] = arr[high];
        arr[high]=temp1;
        quickmoves++;
    }

    public static int quickloops=0;
    public static int quickcomparisons = 0;
    public static int quickmoves = 0;

    public static int part(int[] arr, int first, int last) {   // Partitioning: Takes the pivot element and places all values greater than it on the right, smaller on the left. Only it is in the right place, then keeps repeating.

        random(arr, first, last);
        int pivot = arr[last];

        int i = (first - 1);
        for (int l = first; l < last; l++) {
            quickcomparisons++;
            quickloops++;
            if(arr[l]<pivot){
                i++;


                quickmoves++;
                int t = arr[i];
                arr[i] = arr[l];
                arr[l] = t;

            }
        }
        int t = arr[i+1];
        arr[i+1] = arr[last];
        arr[last] = t;
        quickmoves++;
        return i+1;
    }

    public static void quick(int arr[], int low, int high){ //Executes the quick sort.
        if (low < high){
            int p = part(arr, low, high);

            quick(arr, low, p-1);
            quick(arr, p+1, high);
        }
    }

    public static void PrintQuick(int arr[]){    //Prints out the results of quick sort because I found errors when putting it in the same method as quick.
        System.out.println("\nQuick Sort");
        // for (int i=0; i<arr.length; ++i){
        //     System.out.println(arr[i]+" ");
        // }
        Date t2 = new Date();
        
        System.out.println("Loops: " + quickloops+ "\nComparisons: "+quickcomparisons+ "\nMoves: " + quickmoves+ "\nTime: "+(t2.getTime()-t1.getTime())+"ms");


    }




}
