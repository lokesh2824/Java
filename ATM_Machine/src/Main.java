import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OperationsInterface opi = new OperationImplementation();
        Scanner sc = new Scanner(System.in);
        int actNum = 123456789;
        int atmPin = 7410;
        System.out.println("Welcome to ATM Machine....!");
        System.out.printf("Enter your Account Number: ");
        int actnum = sc.nextInt();
        System.out.printf("Enter your PIN : ");
        int atmpin = sc.nextInt();

        if((actnum==actNum) && (atmpin==atmPin)){
            while (true){
                System.out.println("Enter your choice \n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                int choice = sc.nextInt();

                if (choice == 1){
                    opi.viewBalance();
                }
                else if (choice == 2) {
                    System.out.printf("Enter Amount to Withdraw : ");
                    double withdraw = sc.nextDouble();
                    opi.withdrawAmount(withdraw);
                }
                else if (choice == 3){
                    System.out.printf("Enter Amount to Deposit : ");
                    double deposit = sc.nextDouble();
                    opi.depositAmount(deposit);
                }
                else if (choice == 4){
                    opi.viewMiniStatement();
                }
                else if (choice == 5){
                    System.out.println("Thank you for using ATM...\nPlease collect your ATM card...!");
                    System.exit(0);
                }
                else{
                    System.out.println("Enter correct choice");
                }
            }
        }else {
            System.out.println("Invalid Credentials");
            System.exit(0);
        }
    }
}