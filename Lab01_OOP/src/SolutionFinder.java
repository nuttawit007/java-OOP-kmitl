public class SolutionFinder {
    public static void main(String[] args) {
        double a = 4, b = 8, c = 3;
        double result1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        double result2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
        System.out.println(result1);
        System.out.println(result2);
    }
}
