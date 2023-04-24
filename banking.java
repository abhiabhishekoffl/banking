import java.util.Scanner;

class BankingApplication
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("abhi" , "1001");
        bank1.showMenu();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname , String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount != 0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        if(amount != 0)
        {
            balance=balance-amount;
            previousTransaction= -amount;
        }
    }

    void getPreviousTransaction()
    {
        if(previousTransaction > 0 )
        {
            System.out.println("Deposited : " + previousTransaction);
        }
        else if(previousTransaction < 0 )
        {
            System.out.println("withdraw : " + previousTransaction);
        }
        else
        {
            System.out.println("no transaction is occured...!");
        }
    }

    void showMenu()
    {
        char option ='\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("your id is : " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previour Transaction");
        System.out.println("E. Exit");

        do
        {    
            System.out.println("*************************************");
            System.out.println("enter the option : ");
            option = sc.next().charAt(0);
            Character.toUpperCase(option);

            switch(option)
            {
                case 'A' : 
                    System.out.println("*************************************");
                    System.out.println("Balance is : "+ balance);
                    System.out.println();
                    break;
                
                case 'B' : 
                    System.out.println("*************************************");
                    System.out.println("Enter the amount to deposit : ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C' : 
                    System.out.println("*************************************");
                    System.out.println("Enter te amount to withdraw : ");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D' : 
                    System.out.println("*************************************");
                    getPreviousTransaction();
                    System.out.println();
                    break;

                case 'E' :
                    System.out.println("*********************************");
                    break;

                default : 
                    System.out.println("************Invalid option Please try again************");
            }
        }while(option != 'E');
    }
}