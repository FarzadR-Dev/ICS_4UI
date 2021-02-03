package Assignment_1_ICS_4UI;

// Rock Paper Scissors Lizard Spock

// by Farzad Rahman

// This program is a 1v1 rock paper scissors lizard spock game of user versus CPU
// The user inputs what they want to throw down, and the computer randomly chooses an option, it determines the winner, 
// and grants them the point. First one to 10 points wins.







//Imports
import java.util.*;


public class RockPaperScissorsLizardSpock {
    
    public static void main(String[] args){ 
        int CompScore = 0; 
        int UserScore = 0;
        String UserChoice;
        int CompChoiceNum;
        String CompChoice;
        String[] Choices = {"rock", "paper", "scissors", "lizard", "spock"};

        Scanner sc = new Scanner(System.in);

        while (CompScore != 10 && UserScore != 10) {
            System.out.println("What will you choose? Rock? Paper? Scissors? Lizard? Or Spock?");
            UserChoice = sc.nextLine();
            UserChoice = UserChoice.toLowerCase();
            CompChoiceNum = (int)(Math.random()*Choices.length);
            CompChoice = Choices[CompChoiceNum];

            // Comparisons
            switch (UserChoice) {
                case "rock":
                    if (CompChoice == "rock") {
                        System.out.println("Rock and rock tie, scores remain unchanged."); 
                        break;
                    }
                    if (CompChoice == "paper"){ 
                        System.out.println("Paper suffocates rock, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "scissors") {
                        System.out.println("Rock breaks scissors, User wins this round.");
                        UserScore++;
                        break;
                    }
                    if (CompChoice == "lizard") { 
                        System.out.println("Rock crushes lizard, User wins this round.");
                        UserScore++;
                        break;
                    }
                    if (CompChoice == "spock") {
                        System.out.println("Spock vaporizes rock, Computer wins this round.");
                        CompScore++;
                        break;
                    }



                case "paper":
                    if (CompChoice == "rock"){
                        System.out.println("Paper suffocates rock, User wins this round.");
                        UserScore++;
                        break;
                    }
                    if (CompChoice == "paper"){
                        System.out.println("Paper and paper tie, scores remain unchanged.");                     
                        break;
                    }
                    if (CompChoice == "scissors"){
                        System.out.println("Scissors cuts paper, Computer wins this round");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "lizard"){
                        System.out.println("Lizard eats the flavorful 24-weight letter bond paper, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "spock"){
                        System.out.println("Paper disproves Spock's entire existence, User wins this round.");
                        UserScore++;
                        break;
                    }
                

                case "scissors":
                    if (CompChoice == "rock"){
                        System.out.println("Rock breaks scissors, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "paper"){
                        System.out.println("Scissors cuts paper, User wins this round."); 
                        UserScore++;                 
                        break;
                    }
                    if (CompChoice == "scissors"){
                        System.out.println("Scissors and scissors tie, scores remain unchanged.");
                        break;
                    }
                    if (CompChoice == "lizard"){
                        System.out.println("Scissors decapitates lizard and creates a liveleak video of it, User wins this round.");
                        UserScore++;
                        break; 
                    }
                    if (CompChoice == "spock"){
                        System.out.println("Spock obliterates scissors with his probably non-canonical Vulcan exploding-thing power, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                
                case "lizard":
                    if (CompChoice == "rock"){
                        System.out.println("Rock crushes lizard, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "paper"){
                        System.out.println("Lizard eats the flavorful 24-weight letter bond paper, User wins this round."); 
                        UserScore++;                 
                        break;
                    }
                    if (CompChoice == "scissors"){
                        System.out.println("Scissors decapitates lizard and creates a liveleak video of it, Computer wins this round.");
                        CompScore++;
                        break;
                    }
                    if (CompChoice == "lizard"){
                        System.out.println("Lizard and lizard tie as animal rights advocates intervene, scores remain unchanged.");
                        break;  
                    }
                    if (CompChoice == "spock"){
                        System.out.println("Lizard poisons spock, User wins this round.");
                        UserScore++;
                        break;
                    }


                case "spock":
                        if (CompChoice == "rock"){
                            System.out.println("Spock vaporizes rock, User wins this round.");
                            UserScore++;
                            break;
                        }
                        if (CompChoice == "paper"){
                            System.out.println("Paper disproves Spock's entire existence, Computer wins this round."); 
                            CompScore++;                 
                            break;
                        }
                        if (CompChoice == "scissors"){
                            System.out.println("Spock obliterates scissors with his probably non-canonical Vulcan exploding-thing power, User wins this round.");
                            UserScore++;
                            break;
                        }
                        if (CompChoice == "lizard"){
                            System.out.println("Lizard poisons spock, Computer wins this round");
                            CompScore++;
                            break; 
                        }
                        if (CompChoice == "spock"){
                            System.out.println("Spock two is too large to be fathomed in this program, scores remain unchanged.");
                            break;
                        }
                    
                    
                    
            
                default:
                    System.out.println("User's Input Was Invalid, Try Again.");
                    break;
            }

            // Score Update
            System.out.println("Computer: " + CompScore);
            System.out.println("User: " + UserScore);
        }
        if (CompScore > UserScore){
            System.out.println("You lose!");
        }
        else{
            System.out.println("You win!");
        }

        sc.close();
    }

}

