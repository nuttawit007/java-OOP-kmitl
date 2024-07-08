import java.util.Scanner;
public class Century15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("ฺC.E. : ");
        int cristian = input.nextInt();
        int buddhist = cristian+543;
        System.out.println(buddhist);
    }
}
