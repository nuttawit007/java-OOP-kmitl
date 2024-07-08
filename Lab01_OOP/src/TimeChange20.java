import java.util.Scanner;
public class TimeChange20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Hours : ");
        byte hours = input.nextByte();
        System.out.print("Mins : ");
        byte mins = input.nextByte();
        int secs = (hours*60*60)+(mins*60);
        System.out.println("Secs = " + secs);
    }
    
}
