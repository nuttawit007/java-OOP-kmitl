import java.util.Scanner;
public class ExamPoint16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("point1 : ");
        double point1 = input.nextDouble();
        System.out.print("point2 : ");
        double point2 = input.nextDouble();
        System.out.print("point3 : ");
        double point3 = input.nextDouble();
        double avg = (point1 + point2 + point3) / 3;
        System.out.println("Avearge score = " + avg);
    }
    
}
