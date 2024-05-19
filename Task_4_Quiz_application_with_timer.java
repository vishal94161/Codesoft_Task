package com.company;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task_4_Quiz_application_with_timer {

    private static final int TIME_LIMIT = 10; // Time limit in seconds per question
    private static Question[] questions = {
            new Question("What is the capital of Bharat?", new String[]{"A. Chandigarh", "B. Delhi", "C. Bangluru", "D. Maldweep"}, 'B'),
            new Question("What is sq(2020) +sq(2021)?", new String[]{"A. 1324128", "B. 8164841", "C. 89362120", "D. 23231122"}, 'B'),
            new Question("Which is the largest planet in our solar system?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"}, 'C'),
            new Question("Do you love the person who is sitting besides you ?",new String[]{"A. Yes","B. No","C. Both","D. None"},'A'),
            new Question("P(A ∩ B) is equal to:", new String[]{"A. P(A) . P(B|A)", "B. P(B) . P(A|B)", "C. Both A & B", "D. None"}, 'C')
    };
    private static int score = 0;
    private static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].getQuestion());
            for (String option : questions[i].getOptions()) {
                System.out.println(option);
            }
            System.out.print("You got 10 seconds to answer --> ");
            Timer timer = new Timer();
            timeUp = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            }, TIME_LIMIT * 1000);

            char userAnswer = ' ';
            long startTime = System.currentTimeMillis();
            while (!timeUp && System.currentTimeMillis() - startTime < TIME_LIMIT * 1000 && !scanner.hasNextLine()) {
                // wait for input or time up
            }
            if (scanner.hasNextLine()) {
                userAnswer = scanner.nextLine().toUpperCase().charAt(0);
            }
            timer.cancel();

            if (userAnswer == questions[i].getAnswer()) {
                score++;
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.length);
        scanner.close();
    }
}

class Question {
    private String question;
    private String[] options;
    private char answer;

    public Question(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getAnswer() {
        return answer;
    }
}