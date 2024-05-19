package com.company;

import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
            int num,num1,rand,takes=0;
            int rand_num=0;

            Scanner sc = new Scanner(System.in);

            public GuessTheNumber(int a) {
            System.out.print("Enter the number between 1 &100 (0 to exit) --> ");
            num1 = a*3;
            num = sc.nextByte();
            rand_num = set_number();
            guesss();
            }

            public  int set_number(){
                Random random = new Random();
                rand = random.nextInt(1,100);
                return rand;
            }

            public void guesss(){
                while (num!=0 ){

                    num1--;
                    if (num1==0) {
                        System.out.println("The turns run out you lose...");
                        break;}
                if(num>rand_num ){
                    System.out.println("The guess is too high");
                    takes++;
                }
                else if (num<rand_num ){
                    System.out.println("The guess is too low");
                    takes++;
                }
                else{
                     System.out.println("You win in " + takes +" rounds");
                     break;
                 }
                    System.out.print("Enter the number (0 to exit) --> ");
                    num = sc.nextByte();
                }
            }
        }
public class Task_1_Number_game {
    public static void main(String[] args) {
        char c1;
        String ch;
        int difficulty;
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the task 1 --> NUMBER GAME");
        for (int i=0;;i++) {
            System.out.print("The user can change the difficulty of the game \n\t\tInput - 1 (Hard)   \n\t\tInput - 2 (Medium)   \n\t\tInput - 3 (Easy)    \n Input --> ");
            difficulty = sc.nextInt();
            GuessTheNumber guess = new GuessTheNumber(difficulty);
            System.out.print("Does the user wish to continue playing the game (if yes enter 'yes' else 'no')--");
             ch = sc.next();
             c1 = ch.toLowerCase().charAt(0);
            if(c1!='y') break;
        }
    }
}
