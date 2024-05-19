package com.company;
import java.util.Scanner;

class Grade{
    float sum,point;
    int temp,len=100;
    float[] array = new float[20];
    char letter='A';
    int TotalSubjects=0;

    public  void drade(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of subjects --> ");
        TotalSubjects =sc.nextInt();

        for (int i=0;i<TotalSubjects;i++) {

            System.out.format("Enter marks(out of 100) in subject %d -->  ",i+1);
            array[i] =sc.nextFloat();
        }

        for (int i = 0; i < TotalSubjects; i++) {
            sum =sum + array[i];
        }

    }
    public void avg(){
        point =(float) sum/TotalSubjects;

    }
    public void grade(){
        for(int i=1;i<6;i++){
        if (point<(100-i*10)){
            temp = 65 + i;
            letter= (char)temp;

        }else break;
        }
    }
    public void result(){
        System.out.println("Total marks --> " + sum + "\nAverage percentage --> " + point + "%\nGrade --> " + letter);
    }
}
public class Task_2_Grade_Calculator {
    public static void main(String[] args) {
        System.out.println("Task 2 - Student Grade Calculator");
        Grade student=new Grade();
        student.drade();
        student.avg();
        student.grade();
        student.result();
    }
}
