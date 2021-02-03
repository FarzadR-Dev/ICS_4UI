 /*  -------------------- Program Information --------------------
    Name Of Program: GuessTheWord.java
    Date of Creation: 14/12/20
    Name of Author(s): Farzad Rahman
    Course: ICS 4UI
    Description: This game randomly chooses a word from a list of 5 and has the player try to guess the word one letter at a time.
    Similar to hangman, except the user has infinite chances to get the word while it tracks how many attempts and fails were made.


-------------------- Program Information --------------------  */

package Assignment_2_ICS_4UI;

import java.util.*;

public class GuessTheWord {


    
    public static void main(String[] args){
        int Trials = 0;
        int Fails = 0;
        Scanner sc = new Scanner(System.in);
        String[] list = {"Word", "Processor", "Motherboard", "GPU", "Fan", "Ryzen"};
        Random r=new Random();        
      	int randomNumber=r.nextInt(list.length);
        String answer = list[randomNumber].toLowerCase();
        String[] Letters = answer.split("");

        for (int i=0;i<answer.length(); i++) 
        {
            Letters[i] = "-";
        }


        String Progress = "";

        execute(Trials, Progress, Letters, sc, answer, Fails);
    }


    public static void execute(int trials, String progression, String[] characters, Scanner scan, String correct, int incorrect ){   // executes the program's process
        String Try;
        while(true){

            trials++;
            progression = "";
            System.out.println(java.util.Arrays.toString(characters));
        
            System.out.print("Take your guess: ");
            Try = scan.nextLine();
            

            if (Try.length() != 1){
                System.out.println("Woah slow down there, 1 letter at a time. ");
            }

            else if (correct.contains(Try)){
                progression = "";
                for (int i = 0; i < correct.length(); i++){
                    if (correct.charAt(i) == Try.charAt(0)){
                        characters[i] = "" + Try.charAt(0);
                    }
                    progression += characters[i]; 
                }
            }

            else if (!correct.contains(Try)){
                System.out.println("Sorry it does not contain "+Try);
                incorrect++;
            }  

            if (progression.equals(correct)){
                break;
            }

        }
        System.out.println("\nCongrats, you found the word! The word was "+correct);
        System.out.println("\nIt took you "+trials+ " guesses to find the word, and you had "+incorrect+" wrong guesses.");
        scan.close();

    }








}



