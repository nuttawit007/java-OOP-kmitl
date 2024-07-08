import java.util.Scanner;
public class TaxPayment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Salary : ");
        int salary = input.nextInt();
        if (salary > 50000){
            double tax = salary*0.1;
            System.out.println("Tax pay = " + tax);
        }else{
            double tax = salary*0.05;
            System.out.println("Tax pay = " + tax);
        }
    }
}
