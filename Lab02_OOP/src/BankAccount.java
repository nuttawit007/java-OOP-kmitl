import java.util.Scanner;
public class BankAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input your money : ");
        int money = input.nextInt();
        System.out.print("Input your account type(Please type A B C or X in uppercase) : ");
        char type = input.next().charAt(0);
        if (type == 'A'){
            double total = money + (money*0.015);
            System.out.println("Your total money in one year = " + total);
        }else if (type == 'B'){
            double total = money + (money*0.02);
            System.out.println("Your total money in one year = " + total);
        }else if (type == 'C'){
            double total = money + (money*0.015);
            System.out.println("Your total money in one year = " + total);
        }else if (type == 'X'){
            double total = money + (money*0.05);
            System.out.println("Your total money in one year = " + total);
        }
    }
    
}
