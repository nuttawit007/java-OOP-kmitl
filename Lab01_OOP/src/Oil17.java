import java.util.Scanner;
public class Oil17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("liter : ");
        double liter = input.nextDouble();
        double pay = liter*30;
        System.out.println("payment = " + pay);
    }
    
}
