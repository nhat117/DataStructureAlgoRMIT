package W9;

import java.util.Random;
import java.util.Scanner;
/*
Implement a program that guesses a secret number. First, the player needs to think of a number from 1 to 1,000,000. Then, the program will guess that number and ask the player if the guessed value is correct. The player will answer whether the value is correct, too small, or too big. If the value is not correct (i.e., it is too small or too big), the program needs to guess another number until it knows the correct value.


 */
public class W9P3 {
    public static void main(String[] args) {
        int range = 1000;
        startGame(range);
    }

    static void startGame(int range) {
        boolean correct = false;
        int guessedNum = 0;
        int guessedCount = 0;
        int low = 0, high = range;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to guessing game - Think of one number from 0 - " + range);
        System.out.println("-------------------------------------------------------------");
        while(!correct) {
            guessedNum = guessedNum(low, high);
            guessedCount ++;
            System.out.println("Is : " + guessedNum + "? (y/n): ");
            String answer = scanner.next();
            if(answer.toLowerCase().equals("y")) {
                correct = true;
                break;
            } else {
                System.out.println("Small or big ? (S/B): ");
                String nextAns = scanner.next();
                if(nextAns.toLowerCase().equals("s")) {
                    low = guessedNum + 1;
                } else {
                    high = guessedNum -1;
                }
            }
        }
        scanner.close();
        System.out.println("The number is: " + guessedNum);
        System.out.println("Number of guesses: " + guessedCount);
    }
    static int guessedNum(int low, int high) {
        Random r = new Random();
        int signed = r.nextInt(2) - 1;
        int width = (high - low) / 10;
        int diff = 0;
        if(width > 0) {
            diff = signed * r.nextInt(width);
        }
        int guessedNum = (low + high)/2 + diff;
        if(guessedNum < low) return low;
        if(guessedNum > high) return high;
        return guessedNum;
    }
}
