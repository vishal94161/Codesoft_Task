package com.company;

import java.util.Scanner;

class Atm_machine{
        float take,balance_final;
        float balance_initial =0f;
        Scanner sc = new Scanner(System.in);

        public void Deposit(float setDeposit){
            balance_final = balance_initial + setDeposit;
            System.out.println("You have deposited --> " + setDeposit +"\nBalance --> " + balance_final);
            balance_initial = balance_final;

        }
        public void Withdraw(float withdraw){
            if(withdraw>balance_final){
                System.out.println("Withdrawal amount is greater than the amount of balance in the bank");
                System.out.print("Enter amount less than " + balance_final + "  --> ");
                take =sc.nextFloat();
                Withdraw(take);

            }else{
            balance_final = balance_final - withdraw;
            System.out.println("You have withdrawn --> "+withdraw+"\nBalance --> " + balance_final);
            balance_initial=balance_final;
            }
        }
        public void CheckBalance(){
            System.out.println("Balance --> "+balance_final);
        }

}
class Bank_account{
    float account_balance;
    long account_number;
    public void getAccount_number() {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter your account number --> ");
        account_number = sc.nextLong();
        System.out.println("Processing your account details");

    }
}


public class Task_3_ATM_Interface {
    public static void main(String[] args) {
        float initial_balance = 0,account_number;
        int n;
        float amount;
        Scanner sc =new Scanner(System.in);
        System.out.println("Task 3 --> ATM INTERFACE");
        Bank_account ba = new Bank_account();
        ba.getAccount_number();
        System.out.println("Your account has initial balance = 0.0");
        Atm_machine atm = new Atm_machine();
        System.out.print("Enter the amount you wish to deposit --> ");
        initial_balance = sc.nextFloat();
        atm.Deposit(initial_balance);
        for (int i=0;;i++){
            System.out.println("Enter 1 to deposit  ");
            System.out.println("Enter 2 to withdraw ");
            System.out.println("Enter 3 to check balance ");
            System.out.print("Enter 0 to exit.\nAction-->");
            n= sc.nextByte();
            if(n==0) break;
            switch (n){
                case 1:
                    System.out.print("Enter the amount to deposit --> ");
                    amount=sc.nextFloat();
                    atm.Deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw --> ");
                    amount =sc.nextFloat();
                    atm.Withdraw(amount);
                    break;
                case 3:
                    atm.CheckBalance();
                    break;
                default:
                    break;
            }
        }

    }
}
