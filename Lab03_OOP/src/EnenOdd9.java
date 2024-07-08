import java.util.Scanner;
public class EnenOdd9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int even_num = 0, odd_num = 0;
        while (true){
            int num = input.nextInt();
            if (num == -1){
                break;
            }
            if (num%2 == 0){
                even_num += 1;
            }else{
                odd_num += 1;
            }
        }
        System.out.println("Odd number = "+odd_num+" and Even number = "+even_num);
    }
}
