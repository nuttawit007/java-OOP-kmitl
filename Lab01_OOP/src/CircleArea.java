import java.util.Scanner;
public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Radius : ");
        double radius = input.nextDouble();
        double area = Math.PI*Math.pow(radius, 2);
        System.out.println(area);
    }
}
