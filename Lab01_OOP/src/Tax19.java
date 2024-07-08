import java.util.Scanner;
public class Tax19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Food price : ");
        double price = input.nextDouble();
        double pay = price + (price*0.07);
        System.out.println("Payment = " + pay);
    }
    
}
