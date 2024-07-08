import java.util.Scanner;
public class BuyComputer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert your monitor size 38 or 43 only : ");
        byte monitor = input.nextByte();
        System.out.print("Do you want DVD-ROM? 1 is Yes / 0 is NO : ");
        byte dvd = input.nextByte();
        System.out.print("Do you want printer? 1 is Yes / 0 is NO : ");
        byte printer = input.nextByte();
        
        System.out.println("======= Your order =======");
        double computer = 375.99;
        System.out.println("*computer >>> 375.99$");
        if (monitor == 38){
            computer += 75.99;
            System.out.println("*38'Monitor >>> 75.99$");
        }else if (monitor == 43){
            computer += 99.99;
            System.out.println("*43'Monitor >>> 99.99$");
        }
        if (dvd == 1){
            computer += 65.99;
            System.out.println("*DVD-ROM >>> 65.99$");
        }
        if (printer == 1){
            computer += 125;
            System.out.println("*Printer >>> 125.00$");
        }
        System.out.println("======= Total price >>> " + computer + " =======");
    }
}
