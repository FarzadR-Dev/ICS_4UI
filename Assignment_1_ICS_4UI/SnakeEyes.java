package Assignment_1_ICS_4UI;
// Snake Eyes

// by Farzad Rahman

// This program rolls two dice over and over until snake eyes (both rolled 1) is achieved.




public class SnakeEyes {
    public static void main(String[] args) {
        int D1, D2;
        int count = 0;
    

    do {
        count++;
        D1 = (int)(Math.random()*6)+1;
        D2 = (int)(Math.random()*6)+1;
        System.out.println("You rolled " + D1 + " and " + D2);
    }
    while (D1 != 1 || D2 != 1);

    System.out.println("You got snake eyes!");
    System.out.println("It took " + count + " rolls.");
    }
    
}
    
